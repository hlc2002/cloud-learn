package com.hlc.cloud.service;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlc.cloud.dao.ProductMapper;
import com.hlc.cloud.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    private final QueryWrapper<Product> wrapper = new QueryWrapper<>();

    /**
     * 按照Id查询商品
     *
     * @param id id
     * @return Product
     */
    public Product getProductById(int id) {
        try {
            wrapper.eq("id", id);
            return productMapper.selectOne(wrapper);
        } catch (Exception e) {
            log.error("商品查询模块查询商品id越界:{}",e.getMessage());
            return null;
        }finally {
            wrapper.clear();
        }
    }
}
