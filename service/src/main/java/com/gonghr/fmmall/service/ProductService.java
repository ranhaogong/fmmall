package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;

public interface ProductService {

    public Result getProductById(String productId);

    public Result getProductByCategoryId(int categoryId, int pageNum, int limit);

    public Result listBrands(int categoryId);

    public Result queryProductByKeyword(String kw, int pageNum, int limit);

    public Result listBrands(String kw);
}
