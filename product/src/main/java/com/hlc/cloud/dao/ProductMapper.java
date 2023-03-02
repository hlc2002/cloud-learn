package com.hlc.cloud.dao;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlc.cloud.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
