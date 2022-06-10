package com.gonghr.fmmall.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.gonghr.fmmall.service.OrdersService;
import com.gonghr.fmmall.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
@Api(value = "支付管理相关接口", tags = "支付管理")
public class PayController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/callback")
    public String success(HttpServletRequest request) throws Exception {
        // 1.接收微信⽀付平台传递的数据（使⽤request的输⼊流接收）
        ServletInputStream is = request.getInputStream();
        byte[] bs = new byte[1024];
        int len = -1;
        StringBuilder builder = new StringBuilder();
        while ((len = is.read(bs)) != -1) {
            builder.append(new String(bs, 0, len));
        }
        String s = builder.toString();
        //使⽤帮助类将xml接⼝的字符串装换成map
        Map<String, String> map = WXPayUtil.xmlToMap(s);
        if (map != null && "success".equalsIgnoreCase(map.get("result_code"))) {
            //⽀付成功
            //2.修改订单状态为“待发货/已⽀付”
            String orderId = map.get("out_trade_no");
            int i = ordersService.updateOrderStatus(orderId, "2");
            System.out.println("--orderId:" + orderId);
            //3.通过websocket连接，向前端推送消息
            WebSocketServer.sendMsg(orderId,"1");
            //4.响应微信⽀付平台
            if (i > 0) {
                HashMap<String, String> resp = new HashMap<>();
                resp.put("return_code", "success");
                resp.put("return_msg", "OK");
                resp.put("appid", map.get("appid"));
                resp.put("result_code", "success");
                return WXPayUtil.mapToXml(resp);
            }
        }
        return null;
    }
}
