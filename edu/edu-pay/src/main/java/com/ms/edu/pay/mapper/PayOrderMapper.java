

package com.ms.edu.pay.mapper;

import com.ms.edu.entity.PayOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【pay_order(支付订单信息表)】的数据库操作Mapper
* @createDate 2024-06-19 15:24:21
* @Entity com.ms.edu.entity.PayOrder
*/
public interface PayOrderMapper extends BaseMapper<PayOrder> {

    void deleteByOrderNo(String orderId);
}




