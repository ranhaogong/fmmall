package com.gonghr.fmmall.controller;

import com.github.wxpay.sdk.WXPay;
import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.service.job.MyPayConfig;
import com.gonghr.fmmall.entity.Orders;
import com.gonghr.fmmall.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "订单管理相关接口", tags = "订单管理")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    @ApiOperation("添加订单")
    public Result add(String cids, @RequestBody Orders orders) {
        Result result = null;
        try {
            Map<String, String> orderInfo = ordersService.addOrder(cids, orders);
            String orderId = orderInfo.get("orderId");
            if (orderId != null) {
                //设置当前订单信息
                HashMap<String, String> data = new HashMap<>();
                data.put("body", orderInfo.get("productNames")); //商品描述
                data.put("out_trade_no", orderId); //使⽤当前⽤户订单的编号作为当前⽀付交易的交易号
                data.put("fee_type", "CNY"); //⽀付币种
//                data.put("total_fee", orders.getActualAmount().doubleValue() * 100 + ""); //⽀付⾦额
                data.put("total_fee", "1"); //⽀付⾦额
                data.put("trade_type", "NATIVE"); //交易类型
                data.put("notify_url", "http://回调接口url/pay/callback"); //设置⽀付完成时的回调⽅法接⼝
                //发送请求，获取响应
                //微信⽀付：申请⽀付连接
                WXPay wxPay = new WXPay(new MyPayConfig());
                Map<String, String> resp = wxPay.unifiedOrder(data);
                orderInfo.put("payUrl", resp.get("code_url"));
                result = new Result(ResultCodeEnum.SUBMIT_ORDER_SUCCESS, orderInfo);
            } else {
                result = new Result(ResultCodeEnum.SUBMIT_ORDER_FAILURE, null);
            }
        } catch (SQLException e) {
            result = new Result(ResultCodeEnum.SUBMIT_ORDER_FAILURE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("根据订单ID查询订单状态信息")
    @GetMapping("/status/{oid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "token", value = "token", required = true),
    })
    public Result getOrdersStatus(@PathVariable("oid") String orderId, @RequestHeader("token") String token) {
       return ordersService.queryOrdersById(orderId);
    }

    @ApiOperation("订单查询接口")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "userId", value = "用户ID", required = true),
            @ApiImplicitParam(dataType = "string", name = "status", value = "订单状态"),
            @ApiImplicitParam(dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "每页条数", required = true),
    })
    public Result getOrdersStatus(@RequestHeader("token") String token,
                                  String userId,
                                  String status,
                                  Integer pageNum,
                                  Integer limit) {
        return ordersService.queryOrders(userId, status, pageNum, limit);
    }
}
