package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.OrderItem;
import com.gonghr.fmmall.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDao {
    public int insertOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItemById(String orderId);
}
