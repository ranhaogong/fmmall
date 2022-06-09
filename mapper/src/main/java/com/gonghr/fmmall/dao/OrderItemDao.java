package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.OrderItem;
import com.gonghr.fmmall.entity.Orders;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemDao {
    public int insertOrderItem(OrderItem orderItem);

}
