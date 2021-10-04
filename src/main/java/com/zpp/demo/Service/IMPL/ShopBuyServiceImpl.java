package com.zpp.demo.Service.IMPL;

import com.zpp.demo.Controller.U_shopcar;
import com.zpp.demo.Dao.ShopPage;
import com.zpp.demo.Service.ShopBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShopBuyServiceImpl implements ShopBuyService {

    @Autowired
    ShopPage shopcar;

    @Override
    public int getbookNum(String name) {
        if(name != null){
            return shopcar.getbooknum(name);
        }
        return 0;
    }

    @Override
    public int upbook(String name, int num) {
        if(name !=null && num>0){
            int book_num = getbookNum(name);
            System.out.println(book_num+"wwwsw");
            return  shopcar.upbook(name,String.valueOf(book_num-num));
        }
        return 0;
    }
}
