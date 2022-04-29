package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexDao {

    public List<IndexImg> selectAllIndexImg();

    public List<CategoryVo> selectAllCategory();

    public List<CategoryVo> selectAllCategory2(int parentId);

    public List<ProductVo> selectRecommendProducts();

    public List<ProductImg> selectProductImgByProductId(String id);
}
