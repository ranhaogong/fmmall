package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.Product;
import com.gonghr.fmmall.entity.ProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    public List<Product> queryProductById(String productId);

    /**
     *
     * @param cid 三级分类商品id
     * @param start 起始索引
     * @param limit 查询记录数
     * @return
     */
    public List<ProductVo> queryProductByCategoryId(@Param("cid") int cid,
                                                    @Param("start") int start,
                                                    @Param("limit") int limit);

    /**
     * 根据类别id查询此类别下的商品的数量
     * @param categoryId 类别id
     * @return
     */
    public int queryCountByCategoryId(int categoryId);

    /**
     * 根据类别id查询此类别下的商品的品牌列表
     * @param cid 类别id
     * @return
     */
    public List<String> queryBrandByCatetoryId(int cid);

    /**
     * 根据关键字模糊查询商品信息
     * @param kw 关键字
     * @param start 起始索引
     * @param limit 查询记录数
     * @return
     */
    public List<ProductVo> queryProductByKeyword(@Param("kw") String kw,
                                                 @Param("start") int start,
                                                 @Param("limit") int limit);

    /**
     * 根据搜索关键字统计查询结果总数
     * @param kw
     * @return
     */
    public int queryCountLike(String kw);

    /**
     * 根据搜索关键字查询相关商品的品牌列表
     * @param kw
     * @return
     */
    public List<String> queryBrandByKeyword(String kw);
}
