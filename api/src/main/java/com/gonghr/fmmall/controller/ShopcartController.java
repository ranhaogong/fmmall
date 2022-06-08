package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.entity.ShoppingCart;
import com.gonghr.fmmall.service.ShoppingCartService;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "购物车业务相关接口", tags = "购物车管理")
@RestController
@CrossOrigin
@RequestMapping("/shopcart")
public class ShopcartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

//    @ApiOperation(value = "获取购物车信息")
//    @ApiImplicitParam(dataType = "string", name = "token", value = "授权令牌", required = true)
//    @GetMapping("/list")
//    public Result listCarts(@RequestParam("userId") Integer userId) {
//        return new Result(ResultCodeEnum.TEST, null);
//    }
//

    @ApiOperation(value = "添加购物车信息")
    @ApiImplicitParam(dataType = "ShoppingCart", name = "shoppingCart", value = "购物车对象", required = true)
    @PostMapping("/add")
    public Result addShoppingCart(@RequestBody ShoppingCart shoppingCart, @RequestHeader("token") String token) {
        return shoppingCartService.addShoppingCart(shoppingCart);
    }

    @GetMapping("/list")
    @ApiOperation(value = "查看购物车列表信息")
    @ApiImplicitParam(dataType = "int", name = "userId", value = "用户ID", required = true)
    public Result listShoppingCart(Integer userId, @RequestHeader("token") String token) {
        return shoppingCartService.listShoppingCart(userId);
    }

    @PutMapping("/update/{cid}/{cnum}")
    @ApiOperation(value = "修改购物车列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "cartId", value = "购物车ID", required = true),
            @ApiImplicitParam(dataType = "int", name = "cartNum", value = "修改后的值", required = true)}
    )
    public Result updateShoppingCart(@PathVariable("cid") Integer cartId, @PathVariable("cnum") Integer cartNum, @RequestHeader("token") String token) {
        return shoppingCartService.updateShoppingCart(cartId, cartNum);
    }

    @GetMapping("/listbycids")
    @ApiOperation(value = "查询购物⻋记录信息")
    @ApiImplicitParam(dataType = "String", name = "cids", value = "选择的购物⻋记录id", required = true)
    public Result listByCids(String cids, @RequestHeader("token") String token) {
        Result result = shoppingCartService.listShoppingCartByIds(cids);
        return result;
    }
}
