package com.zpp.demo.Service.IMPL;

import com.zpp.demo.Controller.U_op;
import com.zpp.demo.Dao.Ulogin;
import com.zpp.demo.POJO.U_info;
import com.zpp.demo.POJO.U_up;
import com.zpp.demo.Service.UserloginService;
import com.zpp.demo.Tools.UToekn;
import com.zpp.demo.Tools.carUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserLoginServiceImpl implements UserloginService {
    public static int uid;
     //登录注册接口
     @Autowired
     private Ulogin ulogin;
     @Autowired
     private RedisTemplate<String,String> template;
     @Qualifier("redisTemplate2")
     @Autowired
     private RedisTemplate template2;
     private carUtils carUtils;
     @Autowired
     public  SimpleDateFormat simpleDateFormat;
    //根据用户名获取密码
    public String getPasswordByName(String uname) {
        String passowrd= null;
        passowrd =  ulogin .ulogin(uname);
        return passowrd;
    }
    public carUtils getCarUtils(){
        return this.carUtils;
    }
    //登录
    public UToekn uerlogin(U_up up) {
        String tokenid = null;
        String userpass = getPasswordByName(up.getUsername());
        if(userpass == null){
            return new UToekn(201,tokenid,"账号错误");
        }
        else if(userpass .equals(up.getPassword())){
            tokenid = up.getUsername() + simpleDateFormat.format(new Date());
            List<String> x = new ArrayList<>();
            x.add(tokenid);
            x.add(up.getUsername());
            x.add(ulogin.getid(up.getUsername()));
//            template.opsForValue().set(up.getUsername(),tokenid);   //redis 存储tokenid
             uid = getusername(up.getUsername());
             template.opsForValue().set(up.getUsername(),String.valueOf(uid));
            template2.opsForValue().set(String.valueOf(uid),x);
            return new UToekn(200,tokenid,"登录成功！",up.getUsername());
        }
        return new UToekn(202,tokenid,"密码错误");
    }


    @Override
    public int reginstry1(U_up up) {
       int ur = ulogin.uregin1(up);
        return ur;
    }
    //注册
    @Override
    public UToekn reginstry2(U_info uin) {
        U_up up =  new U_up();
        String x = String.valueOf(uin.getUsername().length()+uin.getPassword().length()); //生成的uid
        uin.setU_id(x);
        up.setU_id(x);
        up.setUsername(uin.getUsername());
        up.setPassword(uin.getPassword());
        if(getPasswordByName(up.getUsername())!=null) return new UToekn(302,null,"用户名已经存在!");
        int ul = reginstry1(up);
        if(ul == 0){
            return new UToekn(301,null,"注册失败");
        }
        int ui = ulogin.uregin2(uin);
        if(ui == 0){
            return new UToekn(301,null,"注册失败");
        }
        template.opsForValue().set("uid",x);
        return new UToekn(300,null,"注册成功去注册吧!");
    }

    @Override
    public int getusername(String uid) {
       return ulogin.getname(uid);
    }

}
