package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "购物车业务相关接口", tags = "购物车管理")
@RestController
@CrossOrigin
@RequestMapping("/shopcart")
public class ShopcartController {

    @ApiOperation(value = "获取购物车信息")
    @ApiImplicitParam(dataType = "string", name = "token", value = "授权令牌", required = true)
    @GetMapping("/list")
    public Result listCarts(@RequestParam("userId") Integer userId) {
        return new Result(ResultCodeEnum.TEST, null);
    }
}
