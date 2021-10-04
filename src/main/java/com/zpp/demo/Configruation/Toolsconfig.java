package com.zpp.demo.Configruation;

import com.zpp.demo.Tools.MyIntecepter;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class Toolsconfig implements WebMvcConfigurer {

    @Bean
   public SimpleDateFormat getTimeFormaat(){
       return new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
   }

   @Bean
    public Date getDate(){
        return new Date();
   }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntecepter()).addPathPatterns("/").excludePathPatterns("/o","/car","/u","/page","/search");
    }

}
