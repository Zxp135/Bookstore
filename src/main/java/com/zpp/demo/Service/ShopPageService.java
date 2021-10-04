package com.zpp.demo.Service;

import com.zpp.demo.POJO.Bookinfo;

import java.util.List;

public interface ShopPageService {

    List<Bookinfo> getbook(int start);
    List<Bookinfo> getbook1(int start);
}
