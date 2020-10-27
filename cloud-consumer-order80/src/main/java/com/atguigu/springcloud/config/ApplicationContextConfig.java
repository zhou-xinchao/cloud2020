package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    /**
     * 将RestTemplate放入SpringBoot容器
     *
     * 什么是RestTemplate
     * RestTemplate提供了多种便捷访问远程Http服务方法，是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的可无端模板工具集
     * @return
     */

    @Bean
    @LoadBalanced    //该注解，赋予RestTemplate的负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}

