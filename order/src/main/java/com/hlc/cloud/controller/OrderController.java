package com.hlc.cloud.controller;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.hlc.cloud.FeignInterface;
import com.hlc.cloud.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@RestController
@RequestMapping("order")
//@DefaultProperties(defaultFallback = "getProductFallBack") 统一对打上hystrix熔断降级的接口配置通用降级方法
public class OrderController implements FeignInterface {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getProductFallBack") //给接口配置hystrix熔断降级方法
    public Product getProductById(@PathVariable("id") int id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("睡两秒等熔断");
        }
        return restTemplate.getForObject("http://product/product/" + id, Product.class);
    }

    /*hystrix降级方法必须与熔断方法保持一致参数，一致返回类型*/
    public Product getProductFallBack(int id) {
        Product product = new Product();
        product.setId(-1);
        product.setProductName("服务熔断");
        return product;
    }

    @Override
    public Product findById(int id) {
        return getProductById(id);
    }
}
