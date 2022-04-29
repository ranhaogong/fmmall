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
public class Product {
    private String productId;
    private String productName;
    private int categoryId;
    private int rootCategoryId;
    private int soldNum;
    private int productStatus;
    private String content;
    private Date createTime;
    private Date updateTime;
}
