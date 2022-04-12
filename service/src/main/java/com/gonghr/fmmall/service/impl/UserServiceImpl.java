package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.common.utils.MD5Utils;
import com.gonghr.fmmall.dao.UserDao;
import com.gonghr.fmmall.entity.User;
import com.gonghr.fmmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public Result userRegister(String username, String password) {
        synchronized (this) {
            User user = userDao.queryUserByName(username);
            if(user == null) {
                String md5 = MD5Utils.md5(password);
                user = new User();
                user.setUsername(username);
                user.setPassword(md5);
                user.setUserImg("img/1.jpg");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = userDao.insertUser(user);
                if(i > 0) {
                    return new Result(ResultCodeEnum.REGISTER_SUCCESS);
                } else {
                    return new Result(ResultCodeEnum.REGISTER_FAILURE);
                }
            }
            else {
                return new Result(ResultCodeEnum.REGISTER_FAILURE_OTHERS);
            }
        }
    }

    @Override
    public Result checkLogin(String username, String password) {
        User user = userDao.queryUserByName(username);
        if(user == null) {
            return new Result(ResultCodeEnum.LOGIN_FAILURE_NO_USERNAME);
        }
        else {
            String md5 = MD5Utils.md5(password);
            if(md5.equals(user.getPassword())){
                return new Result(ResultCodeEnum.LOGIN_SUCCESS, user);
            }
            else {
                return new Result(ResultCodeEnum.LOGIN_FAILURE_WRONG_PASSWORD);
            }
        }
    }
}
