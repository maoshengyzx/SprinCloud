package com.ms.edu.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.PayOrder;
import com.ms.edu.pay.mapper.PayOrderMapper;
import com.ms.edu.pay.service.PayOrderService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pay_order(支付订单信息表)】的数据库操作Service实现
* @createDate 2024-06-19 15:24:21
*/
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder>
    implements PayOrderService {

}




