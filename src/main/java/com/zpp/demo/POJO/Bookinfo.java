package com.zpp.demo.POJO;

import lombok.Data;

import javax.annotation.security.DenyAll;

@Data
public class Bookinfo {
        private String book_where;

        private  String book_name;  //书名

        private String book_price; //价格

        private String book_url;    //图片路径

        private int book_num;

        private String username;

        public boolean equals(Bookinfo bookinfo){
                if(this.book_name == bookinfo.getBook_name()) return true;
        return false;
        }
}
