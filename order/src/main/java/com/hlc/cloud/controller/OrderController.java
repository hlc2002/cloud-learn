package com.hlc.cloud.controller;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.hlc.cloud.FeignInterface;
import com.hlc.cloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") int id) {
         return restTemplate.getForObject("http://product/product/"+id,Product.class);
    }

    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/buyByFeign/{id}")
    public Product getProductByFeign(@PathVariable("id")int id){
        return feignInterface.findById(id);
    }


}
