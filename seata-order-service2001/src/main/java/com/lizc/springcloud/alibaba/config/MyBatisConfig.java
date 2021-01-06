package com.lizc.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.lizc.springcloud.alibaba.dao")
public class MyBatisConfig {
}
