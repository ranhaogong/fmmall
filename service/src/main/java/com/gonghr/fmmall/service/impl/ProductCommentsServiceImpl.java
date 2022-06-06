package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.common.utils.PageHelper;
import com.gonghr.fmmall.dao.ProductCommentsDao;
import com.gonghr.fmmall.entity.ProductCommentsVo;
import com.gonghr.fmmall.service.ProductCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Autowired
    private ProductCommentsDao productCommentsDao;

    /**
     * @param productId 商品ID
     * @param pageNum   查询第几页
     * @param limit     每页记录数
     * @return
     */
    @Override
    public Result getProductCommentsById(String productId, int pageNum, int limit) {
        int start = (pageNum - 1) * limit; // 起始条数
        int count = productCommentsDao.queryCountProductCommentsById(productId); // 总记录数
        int pageCount = (count % limit == 0 ? count / limit : count / limit + 1);
        List<ProductCommentsVo> list = productCommentsDao.queryProductCommentsById(productId, start, limit);
        return new Result(ResultCodeEnum.SUCCESS, new PageHelper<ProductCommentsVo>(count, pageCount, list));
    }

    @Override
    public Result getCommentsCountByProductId(String productId) {
        int goodTotal = productCommentsDao.queryCountGoodProductCommentsById(productId);
        int midTotal = productCommentsDao.queryCountMidProductCommentsById(productId);
        int badTotal = productCommentsDao.queryCountBadProductCommentsById(productId);
        int total = productCommentsDao.queryCountProductCommentsById(productId);
        double percent = (Double.parseDouble(goodTotal + "") / Double.parseDouble(total + "")) * 100;
        String percentValue = (percent + "").substring(0, (percent + "").lastIndexOf(".") + 3);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("goodTotal", goodTotal);
        map.put("midTotal", midTotal);
        map.put("badTotal", badTotal);
        map.put("percent", percentValue);
        return new Result(ResultCodeEnum.SUCCESS, map);
    }
}
