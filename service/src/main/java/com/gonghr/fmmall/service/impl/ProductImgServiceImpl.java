package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ProductImgDao;
import com.gonghr.fmmall.entity.ProductImg;
import com.gonghr.fmmall.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {

    @Autowired
    private ProductImgDao productImgDao;

    @Override
    public Result getProductImgById(String productId) {
        List<ProductImg> productImgs = productImgDao.queryProductImgById(productId);
        return new Result(ResultCodeEnum.SUCCESS, productImgs);
    }
}
