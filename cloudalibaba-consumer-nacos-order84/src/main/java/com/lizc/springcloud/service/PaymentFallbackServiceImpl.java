package com.lizc.springcloud.service;

import com.lizc.springcloud.entities.CommonResult;
import com.lizc.springcloud.entities.Payment;
import org.springframework.stereotype.Service;


@Service
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> PaymentSQL(Long id) {
        return new CommonResult<>(444444444, "服务降级返回，----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}
