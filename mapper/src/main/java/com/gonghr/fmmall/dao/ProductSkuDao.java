package com.gonghr.fmmall.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuDao {
    public List<ProductSkuDao> queryProductSkuById(String productId);
}
