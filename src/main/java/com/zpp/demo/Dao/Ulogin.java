package com.zpp.demo.Dao;

import com.zpp.demo.POJO.U_info;
import com.zpp.demo.POJO.U_up;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Ulogin {

    //mybatis 登录接口
    String ulogin(String username);
   //注册接口
    int uregin2(U_info u_info);
    //注册接口
    int uregin1(U_up up);
    //根据用户名获取Uid
    String getid(String username);
    //获取用户名
    int getname(String uid);
}
