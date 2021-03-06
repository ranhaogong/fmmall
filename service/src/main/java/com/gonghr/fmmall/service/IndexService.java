package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;

public interface IndexService {

    public Result getAllIndexImg();

    public Result getAllCategory();

    public Result getAllCategory2();

    public Result getRecommendProducts();

    public Result getAllCategoryAndTopSixProducts();
}
