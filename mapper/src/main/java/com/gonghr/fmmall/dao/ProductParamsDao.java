package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ProductParams;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductParamsDao {

    public List<ProductParams> queryProductParamsById(String productId);
}
