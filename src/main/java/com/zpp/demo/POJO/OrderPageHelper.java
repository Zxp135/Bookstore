package com.zpp.demo.POJO;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zpp.demo.POJO.Order;
import lombok.Data;

import java.util.List;

/**
 * 数据分页类
 */
@Data
public class OrderPageHelper {

    private String u_id;
    //总页数
    private int TotlePage;
    //当前页码
    private int Page_num;
    //一页数据条数
    private  int ShowPage;
    private String username;
    public OrderPageHelper(){

    }
        public OrderPageHelper(int totlePage, int page, int showPage){
            this.Page_num = page;
            this.TotlePage = totlePage;
            this.ShowPage = showPage;
        }
        public OrderPageHelper(String u_id,int Page_num){
            this.u_id = u_id;
            this.Page_num = Page_num;
        }
}
