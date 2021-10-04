package com.zpp.demo.Service;

public interface ShopBuyService {

    //获取库存
    int getbookNum(String name);
    //跟新库存
    int upbook(String name ,int num);
}
