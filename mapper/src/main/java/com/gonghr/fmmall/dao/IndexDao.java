package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.CategoryVo;
import com.gonghr.fmmall.entity.IndexImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexDao {

    public List<IndexImg> selectAllIndexImg();

    public List<CategoryVo> selectAllCategory();

    public List<CategoryVo> selectAllCategory2(int parentId);
}
