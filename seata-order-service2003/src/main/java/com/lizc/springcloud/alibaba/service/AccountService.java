package com.lizc.springcloud.alibaba.service;

import java.math.BigDecimal;

public interface AccountService {
    /**
     * 扣减账户余额
     *
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
