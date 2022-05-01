package com.gonghr.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryVo {
    private int categoryId;
    private String categoryName;
    private int categoryLevel;
    private int parentId;
    private String categoryIcon;
    private String categorySlogan;
    private String categoryPic;
    private String categoryBgColor;
    private List<CategoryVo> categories;
    private List<Product> products;
}
