package com.zpp.demo.Controller;

import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.POJO.U_info;
import com.zpp.demo.POJO.U_up;
import com.zpp.demo.Service.IMPL.UserLoginServiceImpl;
import com.zpp.demo.Tools.carUtils;
import com.zpp.demo.Service.UserloginService;
import com.zpp.demo.Tools.UToekn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin     //跨域
@RestController
@RequestMapping("/u")
public class U_op {
    @Qualifier("redisTemplate2")
    @Autowired
    private RedisTemplate redisTemplate2;
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private RedisTemplate<String,String> template;
    @Qualifier("redisTemplate2")
    @Autowired
    private RedisTemplate redisTemplate;
    //登录功能
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public UToekn uLogin(@RequestBody U_up user){
            U_shopcar.car = new ArrayList<>();
            UToekn ultoken = userloginService.uerlogin(user);
        return ultoken;
    }
    //获取用户名
    @RequestMapping(value = "/getname",method = RequestMethod.GET)
    public String pushName(){
        String uid = carUtils.userDo;
        if(uid != null){
            return uid;
        }
      return "fail";
    }
    //获取tokenid and name
    @RequestMapping(value = "/getid",method = RequestMethod.POST)
    public UToekn getid(@RequestBody String username){
        System.out.println(username);
        if(username !=null && carUtils.userDo!=null){
        System.out.println(carUtils.userDo);
        List<String> info = null;
        String ws = template.opsForValue().get(carUtils.userDo);
        if(ws != null){
            info = (List<String>) redisTemplate.opsForValue().get(ws);
        if(info == null){
            return new UToekn(1,null,"秘密","未登录");
        }
          return new UToekn(1,info.get(0),"秘密",info.get(1));
        }
        }
        return  new UToekn(1,null,"秘密","未登录");
    }
    //注册功能
    @RequestMapping(value = "/reginstry" , method = RequestMethod.POST)
    public UToekn uReginstry(@RequestBody U_info u_info){
        System.out.println(u_info);
        UToekn utre=  userloginService.reginstry2(u_info);
        return utre;
    }
    //退出功能
    @RequestMapping(value = "/loginout",method = RequestMethod.POST)
    public UToekn logOut(@RequestBody U_up u_up){
        if(u_up.getUsername() == null) return new UToekn(101,null,"退出失败");
        List<String> info = (List<String>) redisTemplate2.opsForValue().get(template.opsForValue().get(u_up.getUsername()));
        System.out.println(u_up.getUsername());
        template.delete(template.opsForValue().get(u_up.getUsername()));
        template.delete(u_up.getUsername());
        template.delete(info.get(2));
        carUtils.userDo=null;
        U_searchBook.xnum = 0;
        System.out.println(U_shopcar.car);
        if(U_shopcar.car!=null){
        U_shopcar.car=null;
        }
        System.out.println("退出");
        return new UToekn(101,null,"退出成功");
    }
}
