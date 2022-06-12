package com.gonghr.fmmall.service.impl;


import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.common.utils.PageHelper;
import com.gonghr.fmmall.dao.ProductDao;
import com.gonghr.fmmall.dao.ProductImgDao;
import com.gonghr.fmmall.dao.ProductSkuDao;
import com.gonghr.fmmall.entity.Product;
import com.gonghr.fmmall.entity.ProductImg;
import com.gonghr.fmmall.entity.ProductVo;
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

    @Override
    public Result getProductByCategoryId(int categoryId, int pageNum, int limit) {
        int start = (pageNum - 1) * limit;
        List<ProductVo> productVos = productDao.queryProductByCategoryId(categoryId, start, limit);
        int count = productDao.queryCountByCategoryId(categoryId);
        int pageCount = count % limit == 0 ? count / limit : count / limit + 1;
        PageHelper<ProductVo> pageHelper = new PageHelper<>(count, pageCount, productVos);
        return new Result(ResultCodeEnum.SUCCESS, pageHelper);
    }

    @Override
    public Result listBrands(int categoryId) {
        List<String> list = productDao.queryBrandByCatetoryId(categoryId);
        return new Result(ResultCodeEnum.SUCCESS, list);
    }

    @Override
    public Result queryProductByKeyword(String kw, int pageNum, int limit) {
        kw = "%" + kw + "%";
        int start = (pageNum - 1) * limit;
        int count = productDao.queryCountLike(kw);
        List<ProductVo> productVos = productDao.queryProductByKeyword(kw, start, limit);
        int pageCount = count % limit == 0 ? count / limit : count / limit + 1;
        PageHelper<ProductVo> pageHelper = new PageHelper<>(count, pageCount, productVos);
        return new Result(ResultCodeEnum.SUCCESS, pageHelper);
    }

    @Override
    public Result listBrands(String kw) {
        kw = "%" + kw + "%";
        List<String> brands = productDao.queryBrandByKeyword(kw);
        return new Result(ResultCodeEnum.SUCCESS, brands);
    }
}
