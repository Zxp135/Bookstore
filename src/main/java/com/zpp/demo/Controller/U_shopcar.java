package com.zpp.demo.Controller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.Service.ShopBuyService;
import com.zpp.demo.Service.UserOrderService;
import com.zpp.demo.Service.UserloginService;
import com.zpp.demo.Tools.UToekn;
import com.zpp.demo.Tools.carUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/car")
@CrossOrigin //跨域
@RestController
public class U_shopcar {

    public static List<Bookinfo> car = new ArrayList<>();
    @Qualifier("redisTemplate2")
    @Autowired
    private RedisTemplate redisTemplate;
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate2;
  private SimpleDateFormat simpleDateFormat;
    @Autowired
    private ShopBuyService shopBuyService;
    @Autowired
    private RedisTemplate<String,String> template;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
 private UserloginService userloginService;
    //购买并生成订单
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public UToekn buy(@RequestBody ForOrder order){
        System.out.println(order);
        if(order.getUsername() == null)  return new UToekn(601,null,"没有登录信息");
        if(order!=null){
            String s = template.opsForValue().get(order.getUsername());
            if(s==null){
                return null;
            }
            List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      int x = 0;
      int x1 = 0;
      if(order!=null){
          order.setOrder_time(simpleDateFormat.format(new Date()));
          x1 = userOrderService.pushOrder(order);
          x = shopBuyService.upbook(order.getBook_name(),Integer.valueOf(order.getBook_num()));
      }
      if(x <= 0  && x1 <= 0){
           return new UToekn(500,null,"购买失败");
         }
            System.out.println(car);
       for(int i = 0; i < car.size();i++){
           car.remove(car.get(i));
           i--;
       }
        redisTemplate2.opsForValue().set(info.get(2),null);
         return new UToekn(520,template.opsForValue().get(info.get(1)),"购买成功");
        }
        return null;
  }
  @RequestMapping(value = "/incar",method = RequestMethod.POST)
  public UToekn incar(@RequestBody  Bookinfo bookinfo){ //加入购物车
      System.out.println(bookinfo);
        if(bookinfo.getUsername() == null)  return new UToekn(601,null,"没有登录信息");
        if(bookinfo!=null){
            String s = template.opsForValue().get(bookinfo.getUsername());
            if(s == null)  return new UToekn(601,null,"没有登录信息");
            List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
            AtomicInteger i = new AtomicInteger(0);
            car.forEach((x)->{
                if(x.getBook_name().equals(bookinfo.getBook_name())){
                    x.setBook_num(x.getBook_num()+1);
                    i.getAndIncrement();
                }
            });
            if(i.get()==0){
                car.add(bookinfo);
            }
            redisTemplate2.opsForValue().set(info.get(2),car);
        return new UToekn(600,info.get(0),"加入成功");
        }
        return new UToekn(601,null,"加入失败");
  }
  //返回当页购物车
  @RequestMapping(value = "/showcar",method = RequestMethod.POST)
    public List<ForOrder> dshowcar(@RequestBody Bookinfo bookinfo){
        if(bookinfo.getUsername() == null) return null;
      int nowcar = bookinfo.getBook_num();
      System.out.println(car);
      List<ForOrder> orders = new ArrayList<>();
        System.out.println(nowcar);
      String s = template.opsForValue().get(bookinfo.getUsername());
      List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
        List<Bookinfo> showcar = (List<Bookinfo>) redisTemplate2.opsForValue().get(info.get(2));
        if(showcar == null) return null;
        System.out.println(((nowcar*3)-3)+"=====>"+(nowcar*3));
        if(nowcar*3>car.size()){
            List<Bookinfo> c1 = showcar.subList((nowcar-1)*3,car.size());
            c1.forEach((x)->{
                orders.add( new ForOrder(x.getBook_name(),x.getBook_num(),x.getBook_num()*Integer.valueOf(x.getBook_price()),x.getBook_price(),x.getBook_url()));
            });
            System.out.println(orders);
            return orders;
        }
         List<Bookinfo> c2 = showcar.subList((nowcar*3)-3,nowcar*3);
         c2.forEach((x)->{
              orders.add( new ForOrder(x.getBook_name(),x.getBook_num(),x.getBook_num()*Integer.valueOf(x.getBook_price()),x.getBook_price(),x.getBook_url()));
        });
//      System.out.println(orders);
         return orders;
  }
  //返回购物车数量
    @RequestMapping(value = "/carnum",method = RequestMethod.GET)
    public int backcarnum(){
        return car.size();
    }

    //删除购物车商品
    @RequestMapping(value = "/delcar",method = RequestMethod.POST)
    public UToekn delcar(@RequestBody Bookinfo bookinfo) {
        if(bookinfo.getUsername() == null)   return new UToekn(500, null, "没有登录信息");
        if (bookinfo != null) {
            String s = template.opsForValue().get(bookinfo.getUsername());
            List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
           int ix = 0;
            Bookinfo bookinfo2=null;
            System.out.println(car.size());
            for(int i = 0;i<car.size();i++){
                bookinfo2 = car.get(i);
                System.out.println(i+"..."+bookinfo2.getBook_name()+"-----==="+bookinfo.getBook_name());
                if(bookinfo2.getBook_name().equals(bookinfo.getBook_name())){
                    System.out.println(car.remove(bookinfo2));
                    ix++;
                    i--;
                }
            }
            if (ix!=0) {
                  redisTemplate2.opsForValue().set(info.get(2),car);
                return new UToekn(500, info.get(0), "删除成功");
            }
        }
        return new UToekn(500, null, "删除失败");
    }
    //购物车结算
    @RequestMapping(value = "/paycar",method = RequestMethod.POST)
    public UToekn payAllcar(@RequestBody Bookinfo bookinfo){
        System.out.println(bookinfo);
        if(bookinfo.getUsername() == null) return  new UToekn(801,null,"没有结算信息");
            if(car!=null){
                System.out.println(car);
                String s = template.opsForValue().get(bookinfo.getUsername());
                List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
                for(int i = 0;i<car.size();i++){
                    Bookinfo x= car.get(i);
//                  String book_name, int book_num, int order_pay,String book_price, String book_url
                   buy(new ForOrder(x.getBook_name(),x.getBook_num(),x.getBook_num()*Integer.valueOf(x.getBook_price()),x.getBook_price(),x.getBook_url(),bookinfo.getUsername()));

              }
                    redisTemplate2.opsForValue().set(info.get(2),null);
              return new UToekn(800,info.get(0),"结算成功");
            }
            return  new UToekn(801,null,"结算失败");
    }
    //更新购物车
    @RequestMapping(value = "/upcar",method = RequestMethod.POST)
    public UToekn upcars(@RequestBody Bookinfo bookinfo){
        if(bookinfo.getUsername() == null) return new UToekn(801,null,"没有登录信息");
        if(bookinfo!=null){
            String s = template.opsForValue().get(bookinfo.getUsername());
            List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
            car.forEach((x)->{
                if(x.getBook_name().equals(bookinfo.getBook_name())){
                    x.setBook_num(bookinfo.getBook_num());
                }
            });
            redisTemplate2.opsForValue().set(info.get(2),car);
            return new UToekn(800,info.get(0),"YES");
        }
        return new UToekn(800,null,"NO");
    }
}
