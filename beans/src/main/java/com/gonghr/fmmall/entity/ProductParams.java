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
public class ProductParams {
    private String paramId;
    private String productId;
    private String productPlace;
    private String footPeriod;
    private String brand;
    private String factoryName;
    private String factoryAddress;
    private String packagingMethod;
    private String weight;
    private String storageMethod;
    private String eatMethod;
    private Date createTime;
    private Date updateTime;
}
