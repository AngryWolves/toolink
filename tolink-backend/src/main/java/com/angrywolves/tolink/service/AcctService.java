package com.angrywolves.tolink.service;

import com.angrywolves.tolink.entity.AcctType;
import com.angrywolves.tolink.mapper.AcctTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gf on 2018/7/25.
 */
@Service
public class AcctService {

    @Autowired
    private AcctTypeMapper acctTypeMapper;

    //查询账目类型
    public List<AcctType> selectAcctType(int start, int size){

        return acctTypeMapper.selectAcctType(start,size);
    }
}
