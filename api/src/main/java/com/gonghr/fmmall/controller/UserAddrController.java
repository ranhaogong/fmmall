package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.service.UserAddrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/useraddr")
@Api(value = "提供收货地址相关接口", tags = "收货地址管理")
public class UserAddrController {

    @Autowired
    private UserAddrService userAddrService;

    @GetMapping("/list")
    @ApiOperation("查询用户收货地址")
    @ApiImplicitParam(dataType = "int", name = "userId", value = "用户ID", required = true)
    public Result listAddr(String userId, @RequestHeader("token") String token) {
        return userAddrService.queryUserAddrById(userId);
    }

}
