package com.gonghr.fmmall.service.impl;


import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.ProductDao;
import com.gonghr.fmmall.dao.ProductImgDao;
import com.gonghr.fmmall.dao.ProductSkuDao;
import com.gonghr.fmmall.entity.Product;
import com.gonghr.fmmall.entity.ProductImg;
import com.gonghr.fmmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    @Autowired
    private ProductSkuDao productSkuDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Result getProductById(String productId) {
        List<Product> products = productDao.queryProductById(productId);
        if (products.size() > 0) {
            List<ProductImg> productImgs = productImgDao.queryProductImgById(productId);
            List<ProductSkuDao> productSkus = productSkuDao.queryProductSkuById(productId);
            Map<String, Object> basicInfo = new HashMap<>();
            basicInfo.put("product", products.get(0));
            basicInfo.put("productImgs", productImgs);
            basicInfo.put("productSkus", productSkus);
            return new Result(ResultCodeEnum.SUCCESS, basicInfo);
        } else {
            return new Result(ResultCodeEnum.FAIL, null);
        }
    }
}
