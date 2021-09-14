package com.phome.yypp.dao;

import com.phome.yypp.pojo.Nums;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NumsMapper {

    int saveNum(Nums nums);

    @Select("select * from nums where num=#{num}")
    List<Nums> selectNum(Nums nums);


    @Select("select * from nums")
    List<Nums> queryNum();
}