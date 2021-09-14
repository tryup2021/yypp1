package com.phome.yypp.service.impl;

import com.phome.yypp.dao.NumsMapper;
import com.phome.yypp.pojo.Nums;
import com.phome.yypp.service.NumsService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class NumsServiceImpl implements NumsService {

    @Autowired
    NumsMapper numsMapper;


    @Override
    public int saveNum(Nums nums) {
        //先查
        if (numsMapper.selectNum(nums).isEmpty()) {
            return numsMapper.saveNum(nums);
        }
        return 0;
    }

    @Override
    public int selectNum(Nums nums) {
        List<Nums> nums1 = numsMapper.selectNum(nums);
        if (nums1.isEmpty()){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public List<Nums> queryNum() {
        return numsMapper.queryNum();
    }
}
