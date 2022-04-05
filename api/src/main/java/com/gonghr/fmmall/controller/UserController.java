package com.gonghr.fmmall.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@Api(value = "管理用户的登录，注册", tags = "用户管理")
public class UserController {

    @RequestMapping(value = "/a", method = RequestMethod.POST)
    public void a(){}
}
