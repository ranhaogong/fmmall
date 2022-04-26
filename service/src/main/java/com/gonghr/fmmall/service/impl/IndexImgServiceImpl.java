package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.IndexImgDao;
import com.gonghr.fmmall.entity.IndexImg;
import com.gonghr.fmmall.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgDao indexImgDao;

    @Override
    public Result getAllIndexImg() {
        List<IndexImg> list = indexImgDao.selectAllIndexImg();
        Result result = new Result(ResultCodeEnum.SUCCESS, list);
        return result;
    }
}
