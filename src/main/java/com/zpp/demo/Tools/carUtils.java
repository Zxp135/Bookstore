package com.zpp.demo.Tools;

import com.zpp.demo.POJO.Bookinfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class carUtils {
    //购物车
    public static List<Bookinfo> car;
    public static String userDo = null;
}
