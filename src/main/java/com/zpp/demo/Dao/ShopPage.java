package com.zpp.demo.Dao;

import com.zpp.demo.POJO.Bookinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopPage {

    List<Bookinfo> getindexbook(int start);
    List<Bookinfo> getindexbook1(int start);
    //获取库存
    int getbooknum(String book_name);
    int upbook(@Param("book_name") String book_name,@Param("book_num") String book_num);
}
