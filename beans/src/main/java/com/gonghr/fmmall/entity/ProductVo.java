package com.gonghr.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVo {
    private String productId;
    private String productName;
    private int categoryId;
    private int rootCategoryId;
    private int soldNum;
    private int productStatus;
    private String content;
    private Date createTime;
    private Date updateTime;
    private List<ProductImg> imgs;
}
