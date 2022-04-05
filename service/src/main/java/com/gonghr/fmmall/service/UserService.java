package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;

public interface UserService {
    //⽤户注册
    public Result userRegister(String username, String password);

    //⽤户登录
    public Result checkLogin(String username, String password);
}
