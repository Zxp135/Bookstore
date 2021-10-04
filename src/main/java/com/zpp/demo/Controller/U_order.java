package com.zpp.demo.Controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.POJO.Order;
import com.zpp.demo.POJO.OrderPageHelper;
import com.zpp.demo.Service.UserOrderService;
import com.zpp.demo.Tools.UToekn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/o")
public class U_order {

    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private RedisTemplate<String,String> template;
    @RequestMapping(value = "/getorder",method = RequestMethod.POST)  //获取分页订单
    public List<Order> getOrder(@RequestBody OrderPageHelper orderPageHelper){
        if(orderPageHelper == null ){
            return null;
        }
        System.out.println(orderPageHelper);
        return userOrderService.getPageData(orderPageHelper);
    }

    @RequestMapping(value = "/getnum",method = RequestMethod.POST)  //获取订单数量
    public int getnum(@RequestBody Bookinfo bookinfo){
        System.out.println(bookinfo);
        return userOrderService.getOrderById(bookinfo.getUsername());
    }

//    @RequestMapping(value = "/puorder",method = RequestMethod.POST)  //生成订单
//    public UToekn pushOrder(@RequestBody ForOrder forOrder){   //生成订单
//        return userOrderService.pushOrder(forOrder);
//    }

    @RequestMapping(value = "/delorder",method = RequestMethod.POST)
    public UToekn delOrder(@RequestBody Order order){  //delete order
        if(order.getUsername() == null) return null;
        if(order.getOrder_num()!=null){
            System.out.println(order.getOrder_num());
            String x = order.getOrder_num();
            return  userOrderService.delorder(x,order);
        }
        return null;
    }
    @RequestMapping(value = "/getorderforname",method = RequestMethod.POST)
    public List<ForOrder> getofname(@RequestBody ForOrder forOrder){
        if(forOrder.getUsername()!=null){
                List<ForOrder> x = userOrderService.getofname("%"+forOrder.getBook_name()+"%");
            System.out.println(x);
            return x;
        }
        return null;
    }
}
