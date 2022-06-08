package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ShoppingCartDao;
import com.gonghr.fmmall.entity.ShoppingCart;
import com.gonghr.fmmall.entity.ShoppingCartVo;
import com.gonghr.fmmall.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Result addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.setCartTime(new Date());
        int i = shoppingCartDao.insertShoppingCart(shoppingCart);
        if (i > 0) {
            return new Result(ResultCodeEnum.SUCCESS, null);
        } else {
            return new Result(ResultCodeEnum.FAIL, null);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Result listShoppingCart(Integer userId) {
        List<ShoppingCartVo> list = shoppingCartDao.listShoppingCart(userId);
        return new Result(ResultCodeEnum.SUCCESS, list);
    }

    @Override
    public Result updateShoppingCart(Integer cartId, Integer cartNum) {
        int i = shoppingCartDao.updateShoppingCart(cartId, cartNum);
        if (i > 0) {
            return new Result(ResultCodeEnum.SUCCESS, null);
        } else {
            return new Result(ResultCodeEnum.FAIL, null);
        }
    }

    @Override
    public Result listShoppingCartByIds(String cids) {
        String[] split = cids.split(",");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        List<ShoppingCartVo> shoppingCartVos = shoppingCartDao.listShoppingCartByIds(list);

        return new Result(ResultCodeEnum.SUCCESS, shoppingCartVos);
    }
}
