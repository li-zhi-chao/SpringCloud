package com.lizc.springcloud.config.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
