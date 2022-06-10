package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.Orders;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao {

    public int insertOrders(Orders orders);

    int updateOrderStatus(String orderId, String status);

    Orders queryOrdersById(String orderId);
}
