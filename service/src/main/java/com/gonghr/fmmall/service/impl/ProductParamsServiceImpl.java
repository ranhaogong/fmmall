package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ProductParamsDao;
import com.gonghr.fmmall.entity.ProductParams;
import com.gonghr.fmmall.service.ProductParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductParamsServiceImpl implements ProductParamsService {

    @Autowired
    private ProductParamsDao productParamsDao;

    @Override
    public Result getParamsById(String productId) {
        List<ProductParams> list = productParamsDao.queryProductParamsById(productId);
        if (list.size() > 0) {
            return new Result(ResultCodeEnum.SUCCESS, list.get(0));
        } else {
            return new Result(ResultCodeEnum.FAIL, null);
        }
    }
}
