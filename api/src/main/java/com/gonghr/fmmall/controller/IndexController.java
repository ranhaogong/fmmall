package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.dao.IndexImgDao;
import com.gonghr.fmmall.service.IndexImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "主页业务相关接口", tags = "主页管理")
@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexImgService indexImgService;

    @ApiOperation(value = "获取主页轮播图")
    @GetMapping("/indeximg")
    public Result getIndexImg() {
        Result result = indexImgService.getAllIndexImg();
        return result;
    }
}
