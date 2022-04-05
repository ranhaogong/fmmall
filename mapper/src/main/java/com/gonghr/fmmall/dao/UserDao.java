package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //⽤户注册
    public int insertUser(User user);
    //根据⽤户名查询⽤户信息
    public User queryUserByName(String username);
}
