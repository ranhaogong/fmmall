package com.gonghr.fmmall.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "User对象",description = "⽤户/买家信息")
public class User {
    private Integer userId;
    private String username;
    private String pasword;
    private String nickname;
    private String realname;
    private String userImg;
    private String userMobile;
    private String userEmail;
    private String userSex;
    private String userBirth;
    private Date userRegtime;
    private Date userModtime;
}
