package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ProductSku;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuDao {
    public List<ProductSkuDao> queryProductSkuById(String productId);

    public int updateByPrimaryKeySelective(ProductSku productSku);
}
