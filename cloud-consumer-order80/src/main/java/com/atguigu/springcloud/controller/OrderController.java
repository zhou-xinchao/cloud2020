package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    //微服务的服务名称
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    //RestTemplate提供了多种便捷访问远程Http服务方法，是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的可无端模板工具集
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",Object.class);
    }

}
