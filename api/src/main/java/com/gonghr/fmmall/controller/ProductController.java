package com.gonghr.fmmall.controller;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.service.ProductCommentsService;
import com.gonghr.fmmall.service.ProductParamsService;
import com.gonghr.fmmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/product")
@Api(value = "提供商品信息相关的接口", tags = "商品管理")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductParamsService productParamsService;

    @Autowired
    private ProductCommentsService productCommentsService;

    @ApiOperation("商品基本信息查询接口")
    @GetMapping("/detail-info/{pid}")
    public Result getProductBasicInfo(@PathVariable("pid") String pid) {
        return productService.getProductById(pid);
    }

    @ApiOperation("商品参数查询接口")
    @GetMapping("/detail-params/{pid}")
    public Result getProductParams(@PathVariable("pid") String pid) {
        return productParamsService.getParamsById(pid);
    }

    @ApiOperation("商品评论查询接口")
    @GetMapping("/detail-comments/{pid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页码", required = true),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "每页显示条数", required = true)
    })
    public Result getProductComments(@PathVariable("pid") String pid, int pageNum, int limit) {
        return productCommentsService.getProductCommentsById(pid, pageNum, limit);
    }

    @ApiOperation("商品评论统计信息查询接口")
    @GetMapping("/detail-commentscount/{pid}")
    public Result getProductCommentsCount(@PathVariable("pid") String pid) {
        return productCommentsService.getCommentsCountByProductId(pid);
    }

}
