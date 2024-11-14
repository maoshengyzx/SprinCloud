package com.ms.edu.controller;

import com.ms.edu.service.PayFegin;
import com.ms.edu.utils.ApiResponse;
import com.ms.edu.vo.PayVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: PayController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 15:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class PayController {

    @Resource
    private PayFegin payFegin;


    /**
     * 生成订单二维码
     *
     * @param courseId
     * @param courseName
     * @param price
     * @return
     */
    @GetMapping("/pay/getCode")
    public ApiResponse getCode(Integer courseId, String courseName, String price, Integer userId) {
        return ApiResponse.success(payFegin.getCode(courseId, courseName, price, userId));
    }

    /**
     * 微信服务器回调地址
     */
    @RequestMapping("/pay/wxCallBack")
    public ApiResponse wxCallBack() {
        return ApiResponse.success(payFegin.wxCallBack());
    }


    /**
     * 保存订单
     *
     * @param orderVO
     * @return
     */
    @GetMapping("/pay/saveOrder")
    public ApiResponse saveOrder(PayVO orderVO) {
        payFegin.saveOrder(orderVO);
        return ApiResponse.success();
    }

    /**
     * 检查订单支付状态
     *
     * @param orderId
     * @return
     */
    @GetMapping("/pay/checkOrderStatus")
    public ApiResponse checkOrderStatus(String orderId) {
        return ApiResponse.success(payFegin.checkOrderStatus(orderId));
    }

    /**
     * 取消订单
     * @param orderNo
     * @return
     */
    @GetMapping("/pay/deleteOrder")
    public ApiResponse deleteOrder(String orderNo) {
        payFegin.deleteOrder(orderNo);
        return ApiResponse.success();
    }

}
