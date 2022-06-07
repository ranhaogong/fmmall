package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ShoppingCart;
import com.gonghr.fmmall.entity.ShoppingCartVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {
    public int insertShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCartVo> listShoppingCart(Integer userId);
}

