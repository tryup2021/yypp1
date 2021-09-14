package com.phome.yypp.service;

import com.phome.yypp.pojo.Nums;

import java.util.List;

public interface NumsService {


    int saveNum(Nums nums);
    int selectNum(Nums nums);
    List<Nums> queryNum();
}
