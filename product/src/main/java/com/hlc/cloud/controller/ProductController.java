package com.hlc.cloud.controller;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.hlc.cloud.entity.Product;
import com.hlc.cloud.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 根据id获取商品信息
     *
     * @param id 商品id
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Integer id) {
        System.out.println(discoveryClient.getInstances("order"));
        return productService.getProductById(id);
    }
}
