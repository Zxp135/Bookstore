package com.zpp.demo.Service.IMPL;

import com.zpp.demo.Dao.searchBook;
import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.Service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksearchServiceImpl implements BookSearchService {

    @Autowired
    searchBook searchBook;

    @Override
    public List<Bookinfo> getfornoname(String name) {  //模糊查询
        char [] x = new char[name.length()+2];
        x[0] = '%';
        x[x.length-1] = '%';
        for(int i = 0;i<name.length();i++){
            x[i+1] = name.charAt(i);
        }
        List<Bookinfo> res = searchBook.fornamegetbook(new String(x));
        return res;
    }

    @Override
    public List<Bookinfo> getforprice(int m1, int m2) {     //价格区间
        return  searchBook.forpricegetbook(m1,m2);
    }
}
