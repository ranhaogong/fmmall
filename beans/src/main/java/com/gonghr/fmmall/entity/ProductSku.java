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
    private Integer originalPrice;
    private Integer sellPrice;
    private Double discounts;
    private Integer stock;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
