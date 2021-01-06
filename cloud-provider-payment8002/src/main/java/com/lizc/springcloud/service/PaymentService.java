package com.lizc.springcloud.service;

import com.lizc.springcloud.entities.Payment;


public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
