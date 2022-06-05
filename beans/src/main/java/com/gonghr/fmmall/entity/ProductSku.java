package com.gonghr.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductSku {
    private String skuId;
    private String productId;
    private String skuName;
    private String skuImg;
    private String untitled;
    private int originalPrice;
    private int sellPrice;
    private double discounts;
    private int stock;
    private Date createTime;
    private Date updateTime;
    private int status;
}
