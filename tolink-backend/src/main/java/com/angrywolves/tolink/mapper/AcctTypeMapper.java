package com.angrywolves.tolink.mapper;

import com.angrywolves.tolink.entity.AcctType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 账目类型
 * Created by gf on 2018/7/23.
 */
@Mapper
@Component
public interface AcctTypeMapper {

    //保存
    Integer saveAcctType(AcctType entity);

    List<AcctType> selectAcctType(@Param("start")int start, @Param("size")int size);
}
