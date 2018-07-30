package com.angrywolves.tolink.mapper;

import com.angrywolves.tolink.entity.AcctDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 账目内容
 * Created by gf on 2018/7/23.
 */
@Mapper
@Component
public interface AcctDetailMapper {

    //保存
    Integer saveAcctDetail(AcctDetail entity);

    //编辑
    Integer updateAcctDetailById(AcctDetail entity);

    //查询
    List<AcctDetail> selectAcctDetail(@Param("userId") Long userId, @Param("start")int start, @Param("size")int size);

    Integer selectAcctDetailCount(@Param("userId") Long userId);
}
