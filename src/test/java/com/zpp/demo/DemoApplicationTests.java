package com.zpp.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zpp.demo.Dao.ShopPage;
import com.zpp.demo.Dao.Uorder;
import com.zpp.demo.Dao.searchBook;
import com.zpp.demo.Dao.searchBook;
import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.POJO.ForOrder;
import com.zpp.demo.POJO.Order;
import com.zpp.demo.POJO.OrderPageHelper;
import com.zpp.demo.Service.BookSearchService;
import com.zpp.demo.Tools.JWTTool;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Spring boot 自带的测试类
 */
@SpringBootTest
class DemoApplicationTests {
	@Qualifier("redisTemplate2")
	@Autowired
	private RedisTemplate<String,List> template;
     @Autowired
	 private SimpleDateFormat format;
     @Autowired
     private Date date;
     @Autowired
	 Uorder uorder;
     @Autowired
	ShopPage shopPage;
     @Autowired
	JWTTool jwtTool;
     @Autowired
	 searchBook searchBook;
     @Autowired
	BookSearchService bookSearchService;
	@Test
	void contextLoads() {
		List<ForOrder> x = uorder.getorforrname("%java%");
		System.out.println(x);
//		List<Bookinfo> x = bookSearchService.getfornoname("www");
//		System.out.println(x.size()==0);
		//			String username = "zpp";
//			String id = "123";
//		    String token = jwtTool.generateToken(username,id,new Date());
//		    System.out.printf(token+"\n 第一个");
//		   Map map = jwtTool.getUserNameFromToken(token);
//		System.out.println(map);
//		map.forEach((k,v)->{
//				System.out.println(k+"."+v+"哦耶");
//			});
//		List<Bookinfo> x = new ArrayList<>();
//		x.add(new Bookinfo());
//		template.opsForValue().set("bookcar",x);
//		System.out.println(template.opsForValue().get("sss"));
//			String x = jwtTool.refreshHeadToken(token);
//			System.out.println(x);
//		System.out.println(shopPage.upbook("J2EE高级编程","101"));
//		System.out.println(uorder.delOrder("00310513"));
//		template.opsForValue().set("chen","wugang");
//		System.out.println(template.opsForValue().get("chen"));
//		Date x = new Date();
//		SimpleDateFormat x1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println(format.format(date));
//		System.out.println(template.opsForValue().get("wwwww"));
//		int x = (int) (Math.random()*5);
//		System.out.println();
//		HashMap<String,Object> map = new HashMap<>();
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.SECOND,60);
		//生成tooken
//		String sign = JWT.create()
//				.withHeader(map) //JWTtooken头部
//				.withClaim("userid", "002")    //JWTtooken负载
//				.withExpiresAt(calendar.getTime())            //过期时间
//				.sign(Algorithm.HMAC512("zppzuiniu"));
//
//
//
//		//生成验证对象d
//		JWTVerifier verifier = JWT.require(Algorithm.HMAC512("zppzuiniu")).build();
//
//		DecodedJWT decodedJWT = verifier.verify(sign);
//
//		System.out.println(decodedJWT.getClaim("userid").asString()+"\n过期时间"+decodedJWT.getExpiresAt());
	}

}
