package com.zpp.demo.Controller;

import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.Service.ShopPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RequestMapping("/page")
@RestController()
@CrossOrigin   //跨域
public class U_Page {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;
    @Autowired
    private RedisTemplate<String,String> template2;
    @Autowired
    private ShopPageService shopPageService;

    @RequestMapping(value = "/getindex1",method = RequestMethod.GET)
   public List<Bookinfo> getindexPage(){
        int x = x= (int) (Math.random()*2);
       return shopPageService.getbook(x);
   }
    @RequestMapping(value = "/getindex2",method = RequestMethod.GET)
    public List<Bookinfo> getindexPage1(){
        int x = x= (int) (Math.random()*2);
        return shopPageService.getbook1(x);
    }
    //记录点击页
    @RequestMapping(value = "/touch",method = RequestMethod.POST)
    public void toview(@RequestBody Bookinfo bookinfo){
        System.out.println(bookinfo);
        template.opsForValue().set("bookview",bookinfo);
    }
    //获取点击详情
    @RequestMapping(value = "/gettouch",method = RequestMethod.GET)
    public Bookinfo getView(){
        return (Bookinfo)template.opsForValue().get("bookview");
    }
}
