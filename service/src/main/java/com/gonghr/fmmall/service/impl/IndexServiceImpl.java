package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.IndexDao;
import com.gonghr.fmmall.entity.CategoryVo;
import com.gonghr.fmmall.entity.IndexImg;
import com.gonghr.fmmall.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;


    @Override
    public Result getAllIndexImg() {
        List<IndexImg> list = indexDao.selectAllIndexImg();
        Result result = new Result(ResultCodeEnum.SUCCESS, list);
        return result;
    }

    @Override
    public Result getAllCategory() {
        List<CategoryVo> list = indexDao.selectAllCategory();
        Result result = new Result(ResultCodeEnum.SUCCESS, list);
        return result;
    }

    @Override
    public Result getAllCategory2() {
        List<CategoryVo> list = indexDao.selectAllCategory2(0);
        Result result = new Result(ResultCodeEnum.SUCCESS, list);
        return result;
    }
}
