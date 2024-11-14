package com.ms.edu.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.PayOrderRecord;
import com.ms.edu.pay.mapper.PayOrderRecordMapper;
import com.ms.edu.pay.service.PayOrderRecordService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pay_order_record(支付订单状态日志表)】的数据库操作Service实现
* @createDate 2024-06-19 15:24:21
*/
@Service
public class PayOrderRecordServiceImpl extends ServiceImpl<PayOrderRecordMapper, PayOrderRecord>
    implements PayOrderRecordService {

}




