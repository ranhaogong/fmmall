package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.Orders;
import com.gonghr.fmmall.entity.OrdersVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrdersDao {

    public int insertOrders(Orders orders);

    public int updateOrderStatus(String orderId, String status);

    public Orders queryOrdersById(String orderId);

    public List<Orders> queryTimeoutJob(Date startTime);

    public int updateOrderStatusAndCloseType(String orderId, String status, Integer closeType);

    public List<OrdersVo> queryOrders(@Param("userId") String userId,
                                      @Param("status") String status,
                                      @Param("start") int start,
                                      @Param("limit") int limit);

    public int queryCountByUserIdAndStatus(@Param("userId") String userId, @Param("status") String status);
}
