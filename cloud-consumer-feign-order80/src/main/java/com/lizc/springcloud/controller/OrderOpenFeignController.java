package com.lizc.springcloud.controller;


import com.lizc.springcloud.service.PaymentFeignService;
import com.lizc.springcloud.entities.CommonResult;
import com.lizc.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class OrderOpenFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * openfeign-ribbon 客户端一般默认等待1秒钟
     * 在支付服务侧,模拟暂停三秒
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        //客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
