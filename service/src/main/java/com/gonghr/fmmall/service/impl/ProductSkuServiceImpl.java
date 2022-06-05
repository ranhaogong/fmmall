package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ProductSkuDao;
import com.gonghr.fmmall.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSkuServiceImpl implements ProductSkuService {

    @Autowired
    private ProductSkuDao productSkuDao;

    @Override
    public Result getProductSkuById(String productId) {
        List<ProductSkuDao> list = productSkuDao.queryProductSkuById(productId);
        return new Result(ResultCodeEnum.SUCCESS, list);
    }
}
