package com.gonghr.fmmall.service;

import com.gonghr.fmmall.entity.Orders;

import java.util.Map;

public interface OrdersService {
    public Map<String,String> addOrder(String cids, Orders order);
}
