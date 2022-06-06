package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.ProductCommentsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsDao {
    public List<ProductCommentsVo> queryProductCommentsById(@Param("productId") String productId, @Param("start") int start, @Param("limit") int limit);
    public int queryCountProductCommentsById(String productId);
    public int queryCountGoodProductCommentsById(String productId);
    public int queryCountBadProductCommentsById(String productId);
    public int queryCountMidProductCommentsById(String productId);

}
