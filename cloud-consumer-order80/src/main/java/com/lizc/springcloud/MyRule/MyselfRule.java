package com.lizc.springcloud.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule {

    //随机规则
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
