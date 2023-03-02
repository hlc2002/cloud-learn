package com.hlc.cloud;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceStarter.class,args);
        log.info("productService模块启动成功");
    }
}
