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
public class ProductImg {
    private String id;
    private String itemId;
    private String url;
    private int sort;
    private int isMain;
    private Date createTime;
    private Date updateTime;
}
