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
public class UserAddr {
    private String addrId;
    private String userId;
    private String receiverName;
    private String receiverMobile;
    private String province;
    private String city;
    private String area;
    private String addr;
    private String postCode;
    private Integer status;
    private Integer commonAddr;
    private Date createTime;
    private Date updateTime;
}
