package com.hlc.cloud.entity;/*
    User: 黄林春
    Date: 2022/10/11
    Time: 周二
    Project_Name: spring_cloud
    */

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private int id;
    private String productName;
    private int status;
    private BigDecimal price;
    private String productDesc;
    private int inventory;
}