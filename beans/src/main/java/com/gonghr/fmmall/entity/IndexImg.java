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
public class IndexImg {
    private String imgId;
    private String imgUrl;
    private String imgBgColor;
    private String prodId;
    private String categoryId;
    private Integer indexType;
    private Integer seq;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
