package com.zpp.demo.Dao;

import com.zpp.demo.POJO.Bookinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface searchBook {

    //根据模糊书名模糊查询书
    List<Bookinfo>  fornamegetbook(@Param("name") String book_name);

    //根据价格区间获取书
    List<Bookinfo> forpricegetbook(@Param("min") int min, @Param("max") int max);


}
