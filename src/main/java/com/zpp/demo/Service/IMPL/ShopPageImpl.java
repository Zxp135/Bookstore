package com.zpp.demo.Service.IMPL;

import com.zpp.demo.Dao.ShopPage;
import com.zpp.demo.POJO.Bookinfo;
import com.zpp.demo.Service.ShopPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopPageImpl implements ShopPageService {
  @Autowired
  private ShopPage shopPage;

    @Override
    public List<Bookinfo> getbook(int start) {

        return shopPage.getindexbook(start);
    }

  @Override
  public List<Bookinfo> getbook1(int start) {
    return shopPage.getindexbook1(start);
  }
}
