package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.entity.ShoppingCart;

public interface ShoppingCartService {

    public Result addShoppingCart(ShoppingCart shoppingCart);

    public Result listShoppingCart(Integer userId);
}
