package com.zpp.demo.Service.IMPL;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zpp.demo.Controller.U_op;
import com.zpp.demo.Dao.Ulogin;
import com.zpp.demo.Dao.Uorder;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.POJO.Order;
import com.zpp.demo.Service.UserOrderService;
import com.zpp.demo.POJO.OrderPageHelper;
import com.zpp.demo.Service.UserloginService;
import com.zpp.demo.Tools.UToekn;
import com.zpp.demo.Tools.carUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserOrderServcieImpl implements UserOrderService {
    @Autowired
    private Uorder uorder;
    @Autowired
    private Ulogin ulogin;
    @Autowired
    private RedisTemplate<String,String> template;
    @Qualifier("redisTemplate2")
    @Autowired
    private RedisTemplate template2;
    @Autowired
    private UserloginService userloginService;
    @Override
    public int getOrderById(String name) {    //获取用户订单数量
       List<String> uid = (List<String>) template2.opsForValue().get(template.opsForValue().get(name));
        System.out.println(uid);
        String u_id = getid(uid.get(1));
        int x = uorder.getOrder(u_id);
        System.out.println(x);
        return x;
    }

    @Override
    public String getid(String name) {
        return ulogin.getid(name);
    }

    //根据页码获取输数据
    @Override
    public List<Order> getPageData(OrderPageHelper orderPageHelper) {
        String id = template.opsForValue().get(orderPageHelper.getUsername());
        List<String> x1 = (List<String>) template2.opsForValue().get(id);
        orderPageHelper.setU_id(getid(x1.get(1)));
        List<Order> x =  uorder.getPageOrder(orderPageHelper);
        return x;
    }

   //生成订单
    public int pushOrder(ForOrder forOrder) {
        String uid = template.opsForValue().get(forOrder.getUsername());
        List<String>  x = (List<String>) template2.opsForValue().get(uid);
        forOrder.setU_id(x.get(2));
        forOrder.setOrder_num("00"+uid.length()+String.valueOf((int)(Math.random()*1000+10000)));
        System.out.println(forOrder);
        int res = uorder.pushOrder(forOrder);
        if(res < 0){
            return res;
        }
        return 0;
    }
    //删除订单
    public UToekn delorder(String uid,Order order) {
        if(uid.isEmpty()){
            return null;
        }
        System.out.println(uid+"xxxs");
        int res = uorder.delOrder(uid);
        System.out.println(res);
        if(res<=0){
            return null;
        }
        String x = template.opsForValue().get(order.getUsername());
        List<String> x1 = (List<String>) template2.opsForValue().get(x);
        return new UToekn(600,x1.get(1),"成功");
    }

    @Override
    public List<ForOrder> getofname(String b_name) {
         List<ForOrder> x = uorder.getorforrname(b_name);
         if(x!=null && x.size() != 0){
                return x;
         }
        return null;
    }


}
