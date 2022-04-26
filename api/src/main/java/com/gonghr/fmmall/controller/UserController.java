package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.entity.User;
import com.gonghr.fmmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Api(value = "管理用户的登录，注册", tags = "用户管理")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("⽤户登录接⼝")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "⽤户登录账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "⽤户登录密码", required = true)
    })
    @GetMapping("/login")
    public Result login(@RequestParam("username") String name,
                        @RequestParam(value = "password") String pwd) {
        Result result = userService.checkLogin(name, pwd);
        return result;
    }

    @ApiOperation("⽤户注册接⼝")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "⽤户注册账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "⽤户注册密码", required = true)})
    @PostMapping("/register")
    public Result regist(@RequestBody User user) {
        Result result = userService.userRegister(user.getUsername(), user.getPassword());
        return result;
    }
}
