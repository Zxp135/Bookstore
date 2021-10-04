package com.zpp.demo.Tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT对比传统的session 和 cookie 机制 ，
 *
 * ------传统的方法对服务器的开销会随着用户的增多的不堪重负，并且在session只能存在于一个用户访问的那个机器上面对于分布式应用不友好，
 *       cookie且容易被截获不安全。
 * ------JWT验证机制是，用户在对于用户名密码形式完成验证之后，会生成一个JWTtooken,返回客户端本地保存，在后续的用户携带JWTtooken访问后端接口时，
 *       后端都会对JWTtooken进行验证，成功则返回用户请求的数据，失败则返回错误信息。
 *       三段式的JWTtooken 又名令牌
 *       头部，负载 签名
 *       header.payload.singurater
 *       header:Base64编码，  包括，令牌类型和加密使用的算法  {‘alg’：“加密算法”，“typ”:"JWT"}
 *       payload: Baser64编码  包括，用户实体数据的声明
 *       singurater：签名，需要 上述两个经过编码后的，加上密钥，以及头部指定的加密算法进行签名。 目的就是防止上诉两者被篡改。
 *       tooken通常都放到HTTP请求的heander中，防止XSS XSRF问题 跨站脚步攻击
 */

//JWT工具类
@Data
@Component
public class JWTTool {
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTTool.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static  HashMap<String,Object> header ;  //token头部
    private static Calendar calendar ;            //过期时间
    private JWTVerifier verification = null;           //验证对象
    static {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,2);  //过期时间是两小时
        header = new HashMap<>();
        header.put("alg","HMAC512");
        header.put("typ","JWT");
    }

      private final  String secret = "zppzuiniubi";       //私钥

      private String tokenHead;   //tooken

    /**
     * 根据中间部分
     * 也就是用户信息负载生成JWTtoken
     */
    private String generateToken(Map<String, String> claims,Date date) {
        JWTCreator.Builder builder =  JWT.create()
                .withHeader(header);
        builder.withClaim("info",claims);
        builder.withClaim("time",date);
        return  builder.sign(Algorithm.HMAC512(secret));  //公钥加密
    }
   /**
    * 验证token是否有效
    */
    private boolean verifierToken(String token) {
        boolean x  = true;
        try {
                 verification = JWT.require(Algorithm.HMAC512(secret)).build();         //生成验证对象
            }catch (Exception e) {
                    x = false;
            }
            return x;
    }
    /**
     * 从token中获取JWT中的负载
     */
    private DecodedJWT getClaimsFromToken(String token) {
        if(!verifierToken(token)) {
            return null;
        }else {
        //Cliams 就是负载类
        DecodedJWT claims = null;
        try {
            //生成token的负载
            claims = verification.verify(token);
        } catch (Exception e) {
            LOGGER.info("JWT格式验证失败:{}", token);
        }
        return claims;
        }
    }
    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + calendar.getTimeInMillis() );
    } /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        return generateExpirationDate();
    }

    /**
     * 从token中的信息
     */
    public Map<String,?> getUserNameFromToken(String token) {
         Map<String,?> map = new HashMap<>();
        if(!verifierToken(token)){
            return  null;
        }else {
           try {
               DecodedJWT decodedJWT = getClaimsFromToken(token);
              map =  decodedJWT.getClaim("info").asMap();
             } catch (Exception e) {
                     map = null;
             }
           return map;
        }
    }


    /**
     * 根据用户信息生成token
     */
    public String generateToken(String name,String id,Date date) {
        Map<String, String> claims = new HashMap<>();
        claims.put("name",name);
        claims.put("id",id);
        return generateToken(claims,date);
    }

    /**
     * 当原来的token没过期时是可以刷新的
     * @param oldToken 带tokenHead的token
     */
    public String refreshHeadToken(String oldToken) {
        if(oldToken.isEmpty()){
            return null;
        }
        //如果token已经过期，不支持刷新
       if(!verifierToken(oldToken))
        {
            return null;
        }
        //如果token在30分钟之内刚刷新过，返回原token
        if(tokenRefreshJustBefore(oldToken,30*60)){
            return oldToken;
        }else{
            Map  map = getUserNameFromToken(oldToken);
            return generateToken(map,new Date());
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time 指定时间（秒）
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
       DecodedJWT claims = getClaimsFromToken(token);
        Date created = claims.getClaim("time").asDate();
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        if(refreshDate.after(created)&&refreshDate.before(generateExpirationDate())){
            return true;
        }
        return false;
    }
}
