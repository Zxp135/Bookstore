package com.zpp.demo.Service;

import com.zpp.demo.POJO.Bookinfo;

import java.util.List;

public interface BookSearchService {


    //模糊查询
    List<Bookinfo> getfornoname(String name);
    //价格区间
    List<Bookinfo> getforprice(int m1,int m2);

}
