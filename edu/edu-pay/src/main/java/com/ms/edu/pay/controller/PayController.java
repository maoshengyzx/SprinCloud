package com.ms.edu.pay.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.wxpay.sdk.WXPayUtil;
import com.jfinal.kit.HttpKit;
import com.ms.edu.entity.PayOrder;
import com.ms.edu.entity.PayOrderRecord;
import com.ms.edu.entity.UserCourseOrder0;
import com.ms.edu.pay.config.PayConfig;
import com.ms.edu.pay.mapper.PayOrderMapper;
import com.ms.edu.pay.mapper.PayOrderRecordMapper;
import com.ms.edu.vo.PayVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pay")
public class PayController {

    @Resource
    private PayOrderMapper payOrderMapper;

    @Resource
    private PayOrderRecordMapper payOrderRecordMapper;

    /**
     * 生产二维码
     *
     * @param courseId
     * @param courseName
     * @param price
     * @return
     * @throws Exception
     */
    @GetMapping("createCode")
    public Object createCode(Integer courseId, String courseName, String price, Integer userId) throws Exception {
        //1.编写商户信息
        Map<String, String> mm = new HashMap();
        mm.put("appid", PayConfig.appid); //公众账号ID
        mm.put("mch_id", PayConfig.partner);//商户号
        mm.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        mm.put("body", courseName); //商品名称
        String orderId = WXPayUtil.generateNonceStr();
        System.out.println("订单编号 = " + orderId);
        mm.put("out_trade_no", orderId); //商户订单号
        mm.put("total_fee", price + ""); //订单金额,单位分
        mm.put("spbill_create_ip", "127.0.0.1"); //终端IP
        mm.put("notify_url", PayConfig.notifyurl); //通知地址
        mm.put("trade_type", "NATIVE"); //交易类型
        System.out.println("发送的map = " + mm.toString());

        //2.生成数字签名,并把上面的map转换成xml格式
        String xml = WXPayUtil.generateSignedXml(mm, PayConfig.partnerKey);
        System.out.println("转换后的xml = " + xml);

        //3.将数据发送给微信后台,并得到微信后台返回的数据
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String result = HttpKit.post(url, xml);
        System.out.println("返回的xml = " + result); //如果报错：<![CDATA[签名错误]]> 商户四要素的原因，重置商户API密钥。

        //4.后台返回的xml格式，转成map，并添加两个参数
        Map<String, String> resultMap = WXPayUtil.xmlToMap(result);
        resultMap.put("orderId", orderId);
        resultMap.put("money", price + "");


        //5.将map返回给浏览器
        return resultMap;
    }


    /**
     * 微信服务器回调地址
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws IOException
     */
    @RequestMapping("wxCallback")
    public String wxCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        InputStream inStream = null;
        ByteArrayOutputStream outSteam = null;
        String resultxml = null;
        try {
            inStream = request.getInputStream();
            outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            resultxml = new String(outSteam.toByteArray(), "utf-8");
        } catch (Exception e) {
            System.out.println("回调处理失败");
        } finally {
            if (null != outSteam) {
                outSteam.close();
            }
            if (null != inStream) {
                inStream.close();
            }
        }
        System.out.println("wxCallback - 回调请求参数:" + resultxml);
        return resultxml;
    }

    /**
     * 检查订单的状态
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @GetMapping("checkOrderStatus")
    public Map<String, String> checkOrderStatus(String orderId) throws Exception {
        //1.编写商户信息
        Map<String, String> mm = new HashMap();
        mm.put("appid", PayConfig.appid); //公众账号ID
        mm.put("mch_id", PayConfig.partner);//商户号
        mm.put("out_trade_no", orderId);//订单编号
        mm.put("nonce_str", WXPayUtil.generateNonceStr()); //随机字符串
        System.out.println(mm);
        //2.生成数字签名,并把上面的map转换成xml格式
        String xml = WXPayUtil.generateSignedXml(mm, PayConfig.partnerKey);
        System.out.println(xml);

        //3.将数据发送给微信后台,并得到微信后台返回的数据
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";

        //第一次询问时间
        long beginTime = System.currentTimeMillis();

        while (true) { //不停的去微信后台询问是否支付
            String result = HttpKit.post(url, xml);
            System.out.println(result);//报错：<![CDATA[签名错误]]>

            //4.后台返回的xml格式，转成map，并添加两个参数
            Map<String, String> resultMap = WXPayUtil.xmlToMap(result);

            //5.将map转成json并返回给浏览器
            //已经成功支付，停止询问
            if (resultMap.get("trade_state").equalsIgnoreCase("success")) {
                return resultMap;
            }
            //超过30秒未支付，停止询问
            if (System.currentTimeMillis() - beginTime > 30000) {
                // 删除订单
                payOrderMapper.deleteByOrderNo(orderId);
                return resultMap;
            }
            Thread.sleep(3000); //每隔3秒，询问一次微信后台
        }
    }

    /**
     * 保存订单
     *
     * @param vo
     */
    @GetMapping("saveOrder")
    @Transactional
    public void saveOrder(PayVO vo) {
        //5.插入数据库订单数据
        PayOrder payOrder = new PayOrder();
        payOrder.setOrderNo(vo.getOrderNo());
        payOrder.setUserId(vo.getUserId());
        payOrder.setProductId(vo.getCourseId());
        payOrder.setAmount(new BigDecimal(vo.getPrice()));
        payOrder.setSource(vo.getSourceType());
        payOrder.setStatus(1);
        payOrder.setCreatedTime(new Date());
        payOrder.setChannel("weChat");

        payOrderMapper.insert(payOrder);

        //6.插入数据库订单记录数据
        PayOrderRecord orderRecord = new PayOrderRecord();
        orderRecord.setOrderNo(vo.getOrderNo());
        orderRecord.setType("CAEATE");
        orderRecord.setToStatus("未支付");
        orderRecord.setCreatedAt(new Date());
        payOrderRecordMapper.insert(orderRecord);
    }

    /**
     * 更新订单状态
     */
    @RequestMapping("updateOrder")
    public void updateOrder(UserCourseOrder0 vo) {
        LambdaQueryWrapper<PayOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayOrder::getOrderNo, vo.getOrderNo());
        PayOrder payOrder = payOrderMapper.selectOne(queryWrapper);
        payOrder.setStatus(Integer.valueOf(vo.getStatus()));
        payOrderMapper.updateById(payOrder);

        PayOrderRecord orderRecord = new PayOrderRecord();
        orderRecord.setOrderNo(vo.getOrderNo());
        orderRecord.setType("CAEATE");
        orderRecord.setFromStatus("未支付");
        orderRecord.setToStatus("已支付");
        orderRecord.setCreatedAt(new Date());
        payOrderRecordMapper.insert(orderRecord);
    }

    /**
     * 取消订单
     *
     * @param orderNo
     */
    @RequestMapping("deleteOrder")
    public void deleteOrder(String orderNo) {
        // 删除订单表数据
        LambdaQueryWrapper<PayOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayOrder::getOrderNo, orderNo);
        payOrderMapper.delete(queryWrapper);

        // 插入订单记录表
        PayOrderRecord record = new PayOrderRecord();
        record.setOrderNo(orderNo);
        record.setFromStatus("未支付");
        record.setToStatus("已取消");
        payOrderRecordMapper.insert(record);
    }
}