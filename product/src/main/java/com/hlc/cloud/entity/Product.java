package com.hlc.cloud.entity;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("tb_products")
public class Product {
    @TableId
    private int Id;
    private String productName;
    private int status;
    private BigDecimal price;
    private String productDesc;
    private int inventory;
}
