package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;

public interface ProductCommentsService {
    public Result getProductCommentsById(String productId, int pageNum, int limit);
    public Result getCommentsCountByProductId(String productId);
}
