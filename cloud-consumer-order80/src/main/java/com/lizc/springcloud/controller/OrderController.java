package com.lizc.springcloud.controller;


import com.lizc.springcloud.PaymentHystrixMain8001.springcloud.config.lb.MyLoadBalancer;
import com.lizc.springcloud.config.lb.MyLoadBalancer;
import com.lizc.springcloud.entities.CommonResult;
import com.lizc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadBalancer myLoadBalancer;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getInstances/{id}")
    public Object getInstances(@PathVariable("id") Long id) {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLoadBalancer.instances(instances);

        return restTemplate.getForObject(instance.getUri() + "/payment/get/" + id, CommonResult.class);

    }

}
