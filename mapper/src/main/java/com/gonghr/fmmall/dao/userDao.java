package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.User;

public interface userDao {
    //⽤户注册
    public int insertUser(User user);
    //根据⽤户名查询⽤户信息
    public User queryUserByName(String name);
}
