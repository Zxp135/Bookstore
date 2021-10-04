package com.zpp.demo.Service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.POJO.Order;
import com.zpp.demo.POJO.OrderPageHelper;
import com.zpp.demo.Tools.UToekn;

import java.util.List;

/*
用户订单服务
 */
public interface UserOrderService {

    //根据uid 查询订单数量
    int getOrderById(String name);
    String getid(String name);
    //获取分页数据
    List<Order> getPageData(OrderPageHelper orderPageHelper);
    //生成订单
    int pushOrder(ForOrder forOrder);
    //删除订单
    UToekn delorder(String uid, Order order);
    //根据书名获取订单
    List<ForOrder> getofname(String b_name);
}
