package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.service.IndexService;
import io.swagger.annotations.Api;
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
    private IndexService indexService;

    @ApiOperation(value = "获取主页轮播图接口")
    @GetMapping("/indeximg")
    public Result getIndexImg() {
        Result result = indexService.getAllIndexImg();
        return result;
    }

    @GetMapping("/category-list")
    @ApiOperation("商品分类查询接⼝")
    public Result listCatetory(){
        return indexService.getAllCategory();
    }

    @GetMapping("/category-list2")
    @ApiOperation("商品分类查询接⼝2")
    public Result listCatetory2(){
        return indexService.getAllCategory2();
    }
}
