package com.zpp.demo.Dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.POJO.Order;
import com.zpp.demo.POJO.OrderPageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Uorder {

            //更具id查询所有订单
       int getOrder(String u_id);
      //查询分页
    List<Order> getPageOrder(OrderPageHelper orderPageHelper);
    //生成订单
    int  pushOrder(ForOrder forOrder);
    //删除订单
    int delOrder(String order_num);

    List<Order> fornamegetorder(String book_name);
    //根据书名获取订单
    List<ForOrder> getorforrname(String book_name);
}
