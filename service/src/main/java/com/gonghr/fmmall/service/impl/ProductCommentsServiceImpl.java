package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ProductCommentsDao;
import com.gonghr.fmmall.entity.ProductCommentsVo;
import com.gonghr.fmmall.service.ProductCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Autowired
    private ProductCommentsDao productCommentsDao;

    @Override
    public Result getProductCommentsById(String productId) {
        List<ProductCommentsVo> list = productCommentsDao.queryProductCommentsById(productId);
        return new Result(ResultCodeEnum.SUCCESS, list);
    }
}
