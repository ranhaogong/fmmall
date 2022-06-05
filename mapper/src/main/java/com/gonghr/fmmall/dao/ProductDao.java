package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    public List<Product> queryProductById(String productId);
}
