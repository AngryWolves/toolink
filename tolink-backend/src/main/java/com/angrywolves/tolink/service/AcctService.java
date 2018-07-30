package com.angrywolves.tolink.service;

import com.angrywolves.tolink.entity.AcctDetail;
import com.angrywolves.tolink.entity.AcctType;
import com.angrywolves.tolink.framework.common.response.QueryResult;
import com.angrywolves.tolink.mapper.AcctDetailMapper;
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
    @Autowired
    private AcctDetailMapper acctDetailMapper;

    //查询账目类型
    public List<AcctType> selectAcctType(int start, int size){

        return acctTypeMapper.selectAcctType(start,size);
    }

    //查询
    public QueryResult<AcctDetail> selectAcctDetailByUserId(Long userId, int start, int size){
        QueryResult<AcctDetail> result = new QueryResult<AcctDetail>();

        List<AcctDetail> lists = acctDetailMapper.selectAcctDetail(userId, start, size);
        Integer total = acctDetailMapper.selectAcctDetailCount(userId);

        result.setRows(lists);
        result.setTotal(total.toString());
        return result;
    }

    //保存账目
    public Integer saveAcctDetail(AcctDetail entity){

        return acctDetailMapper.saveAcctDetail(entity);
    }
}
