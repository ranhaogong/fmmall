package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ShoppingCart;
import com.gonghr.fmmall.entity.ShoppingCartVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {
    public int insertShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCartVo> listShoppingCart(Integer userId);
    public int updateShoppingCart(@Param("cartId") Integer cartId, @Param("cartNum") Integer cartNum);
    public List<ShoppingCartVo> listShoppingCartByIds(List<Integer> cids);
    public int deleteByPrimaryKey(Integer cid);
}

