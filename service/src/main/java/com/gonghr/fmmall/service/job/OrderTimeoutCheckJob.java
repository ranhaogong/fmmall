package com.gonghr.fmmall.service.job;

import com.github.wxpay.sdk.WXPay;
import com.gonghr.fmmall.dao.OrderItemDao;
import com.gonghr.fmmall.dao.OrdersDao;
import com.gonghr.fmmall.dao.ProductSkuDao;
import com.gonghr.fmmall.entity.OrderItem;
import com.gonghr.fmmall.entity.Orders;
import com.gonghr.fmmall.entity.ProductSku;
import com.gonghr.fmmall.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderTimeoutCheckJob {


    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersService ordersService;

    @Scheduled(cron = "0/60 * * * * ?")
    public void checkAndCloseOrder() {
        List<Orders> orders = ordersDao.queryTimeoutJob(new Date(System.currentTimeMillis() - 30 * 60 * 1000));
        WXPay wxPay = new WXPay(new MyPayConfig());
        for (Orders order : orders) {
            HashMap<String, String> params = new HashMap<>();
            params.put("out_trade_no", order.getOrderId());
            Map<String, String> resp = null;
            try {
                resp = wxPay.orderQuery(params);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("SUCCESS".equalsIgnoreCase(resp.get("trade_state"))) {
                ordersDao.updateOrderStatus(order.getOrderId(), order.getStatus());
            } else if ("NOTPAY".equalsIgnoreCase(resp.get("trade_state"))) {
                try {
                    Map<String, String> map = wxPay.closeOrder(params);
                    System.out.println(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ordersService.closeOrder(order.getOrderId());
            }
        }
    }
}
