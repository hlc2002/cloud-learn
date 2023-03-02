package com.hlc.cloud;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class OrderServiceStarter {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceStarter.class,args);
        log.info("OrderServer模板启动成功");
    }
}
