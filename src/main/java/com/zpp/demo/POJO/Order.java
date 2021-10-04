package com.zpp.demo.POJO;

import lombok.Data;

@Data
public class Order {
    //订单编号
    private String order_num;
    //商品名称
    private String book_name;
   //商品数量
    private int book_num;
    //订单总价
    private int order_pay;
    //付款时间
    private String order_time;
    //商品单价
    private String  book_price;
    private String  book_url;
    private String username;

}
