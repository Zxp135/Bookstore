package com.zpp.demo.Controller;

import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.Service.BookSearchService;
import com.zpp.demo.Tools.UToekn;
import com.zpp.demo.Tools.carUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin //跨域
@RequestMapping("/search")
@RestController
public class U_searchBook {

    @Autowired
    private BookSearchService bookSearchService;
    @Qualifier("redisTemplate2")
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate1;
    public static int xnum = 0;
    @RequestMapping(value = "/getforname",method = RequestMethod.POST)
    public List<Bookinfo> getforn(@RequestBody String num){
        System.out.println(num);//模糊查询
           String name = redisTemplate1.opsForValue().get("sbook");
            if(name != null){
                List<Bookinfo> x = bookSearchService.getfornoname(name);
                xnum = x.size();
                if(xnum == 0) return null;
                int bn = Integer.valueOf(num);
                if(bn == 1 && bn*8 > x.size() ) return x.subList(0,x.size());
                if(bn*8 > x.size()) return x.subList(((bn-1)*8-8),x.size());
                if(x.size() != 0){
                    return  x.subList((bn*8-8),bn*8);
                }
                return null;
            }
            return null;
    }
    @RequestMapping(value = "/ln",method = RequestMethod.GET)
    public int getln(){
        return xnum;
    }
    @RequestMapping(value = "/getfn",method = RequestMethod.POST)
    public UToekn  getnf(@RequestBody Bookinfo bookinfo){
            if(bookinfo.getBook_name()!=null){
                if(bookinfo.getUsername() == null) return new UToekn(803,null,"还未登录");
                String s = redisTemplate1.opsForValue().get(bookinfo.getUsername());
                if(s==null){
                     return new UToekn(802,null,"查询失败");
                }
                List<String> info = (List<String>) redisTemplate.opsForValue().get(s);
                redisTemplate1.opsForValue().set("sbook",bookinfo.getBook_name());
                return new UToekn(800,info.get(0),"查询成功");
            }
            return new UToekn(802,null,"查询失败");
    }

    @RequestMapping(value = "/getforprice",method = RequestMethod.POST)
    public List<Bookinfo> getforp(@RequestBody String min){//价格区间
        System.out.println(min);
        if(min!=null){
            String x1 = min.substring(1,3);
            System.out.println(x1);
            String x2 = min.substring(4,6);
            if(x1.equals("90")) x2 = "0";
            System.out.println(x2);
            List<Bookinfo> x = bookSearchService.getforprice(Integer.valueOf(x1),Integer.valueOf(x2));
            System.out.println(x);
            if(x.size()!=0) return x;
        }
        return null;
    }

}
