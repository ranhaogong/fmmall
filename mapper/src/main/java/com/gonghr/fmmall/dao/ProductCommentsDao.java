package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ProductCommentsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsDao {
    public List<ProductCommentsVo> queryProductCommentsById(String productId);
}
