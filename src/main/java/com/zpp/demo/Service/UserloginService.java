package com.zpp.demo.Service;

import com.zpp.demo.POJO.U_info;
import com.zpp.demo.POJO.U_up;
import com.zpp.demo.Tools.UToekn;
import com.zpp.demo.Tools.carUtils;


public interface UserloginService {


    //根据用户名查询密码
    String getPasswordByName(String uname);

    UToekn uerlogin(U_up up);
     carUtils getCarUtils();
    //注册
    int  reginstry1(U_up up );
    UToekn reginstry2(U_info uin);
    //根据uid获取用户名
    int getusername(String uid);

}
