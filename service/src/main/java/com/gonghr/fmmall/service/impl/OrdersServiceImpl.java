package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.dao.OrderItemDao;
import com.gonghr.fmmall.dao.OrdersDao;
import com.gonghr.fmmall.dao.ProductSkuDao;
import com.gonghr.fmmall.dao.ShoppingCartDao;
import com.gonghr.fmmall.entity.OrderItem;
import com.gonghr.fmmall.entity.Orders;
import com.gonghr.fmmall.entity.ProductSku;
import com.gonghr.fmmall.entity.ShoppingCartVo;
import com.gonghr.fmmall.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private ProductSkuDao productSkuDao;

    @Override
    @Transactional
    public Map<String,String> addOrder(String cids, Orders order) {
        //1.校验库存：根据cids查询当前订单中关联的购物⻋记录详情（包括库存）
        String[] arr = cids.split(",");
        ArrayList<Integer> cidsList = new ArrayList<Integer>();
        for (String s : arr) {
            cidsList.add(Integer.parseInt(s));
        }
        List<ShoppingCartVo> list = shoppingCartDao.listShoppingCartByIds(cidsList);
        boolean flag = true;
        String untitled = "";
        for (int i = 0; i < list.size(); i++) {
            ShoppingCartVo sc = list.get(i);
            if (sc.getCartNum() > sc.getStock()) {
                flag = false;
            }
            //获取所有商品名称，以,分割拼接成字符串
            untitled += sc.getProductName();
            if (i != list.size() - 1) {
                untitled += ",";
            }
        }
        if (flag) {
            //2.保存订单
            order.setUntitled(untitled);
            order.setCreateTime(new Date());
            order.setStatus("1");
            //⽣成订单编号
            String orderId = UUID.randomUUID().toString().replace("-", "");
            order.setOrderId(orderId);
            int i = ordersDao.insertOrders(order);
            //3.⽣成商品快照
            for (ShoppingCartVo sc : list) {
                int cnum = sc.getCartNum();
                String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
                OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductId(), sc.getSkuId(), sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), new Date(), new Date(), 0);
                orderItemDao.insertOrderItem(orderItem);
            }
            //4.扣减库存：根据套餐ID修改套餐库存量
            for (ShoppingCartVo sc : list) {
                String skuId = sc.getSkuId();
                int newStock = sc.getStock() - sc.getCartNum();
                ProductSku productSku = new ProductSku();
                productSku.setSkuId(skuId);
                productSku.setStock(newStock);
                productSkuDao.updateByPrimaryKeySelective(productSku);
            }

            //5.删除购物⻋：当购物⻋中的记录购买成功之后，购物⻋中对应做删除操作
            for (int cid : cidsList) {
                shoppingCartDao.deleteByPrimaryKey(cid);
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("orderId", orderId);
            map.put("productNames", untitled);
            return map;
        } else {
            return null;
        }
    }
}
