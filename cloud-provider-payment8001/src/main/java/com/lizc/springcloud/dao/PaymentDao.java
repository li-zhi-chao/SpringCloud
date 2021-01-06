package com.lizc.springcloud.dao;

import com.lizc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
