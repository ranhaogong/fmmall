package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgDao {

    public List<ProductImg> queryProductImgById(String productId);
}
