package com.baidu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //@Configuration  相当于 applicationContext.xml

    //配置负载均衡
    @LoadBalanced  //Ribbon就行了 通过Irule可以 自定义轮询算法
    //配置bean
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
