package com.zpp.demo.POJO;

import lombok.Data;

@Data
public class ForOrder {
    //用户名
    private String username;
    //uid
    private String u_id;
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

    private String book_url;

    public ForOrder() {}

    public ForOrder( String book_name, int book_num, int order_pay,String book_price, String book_url) {
        this.book_name = book_name;
        this.book_num = book_num;
        this.order_pay = order_pay;
        this.book_price = book_price;
        this.book_url = book_url;
    }
    public ForOrder( String book_name, int book_num, int order_pay,String book_price, String book_url,String username) {
        this.book_name = book_name;
        this.book_num = book_num;
        this.order_pay = order_pay;
        this.book_price = book_price;
        this.book_url = book_url;
        this.username = username;
    }
}
