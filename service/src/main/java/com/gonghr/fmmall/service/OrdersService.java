package com.gonghr.fmmall.service;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.entity.Orders;

import java.util.Map;

public interface OrdersService {
    public Map<String,String> addOrder(String cids, Orders order);

    public int updateOrderStatus(String orderId, String status);

    public Result queryOrdersById(String orderId);
}
