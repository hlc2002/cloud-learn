package com.hlc.cloud;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hlc.cloud.dao.ProductMapper;
import com.hlc.cloud.entity.Product;
import com.hlc.cloud.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void test1(){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("Id",1);
        List<Product> products = productMapper.selectList(wrapper);
        Product product = products.get(0);
        System.out.println(product);
    }

    @Test
    public void test2(){
        Product productById = productService.getProductById(1);
        System.out.println(productById);
    }
}
