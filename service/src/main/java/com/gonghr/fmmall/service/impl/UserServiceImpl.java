package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.common.utils.MD5Utils;
import com.gonghr.fmmall.dao.UserDao;
import com.gonghr.fmmall.entity.User;
import com.gonghr.fmmall.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

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
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                String token = builder.setSubject(username)      // 设置token携带的数据
                        .setIssuedAt(new Date())  // 设置token生成时间
                        .setId(user.getUserId() + "")  // 设置用户id为token的id
                        .setClaims(map)           // map中可以设置用户的权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "gonghr")
                        .compact();

                return new Result(10000, token, user);
            }
            else {
                return new Result(ResultCodeEnum.LOGIN_FAILURE_WRONG_PASSWORD);
            }
        }
    }
}
