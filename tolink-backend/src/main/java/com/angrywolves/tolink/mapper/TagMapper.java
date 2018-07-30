package com.angrywolves.tolink.mapper;

import com.angrywolves.tolink.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 标签
 * Created by gf on 2018/7/23.
 */
@Mapper
@Component
public interface TagMapper {

    //保存
    Integer saveTag(Tag entity);

    //查询
    List<Tag> selectTag(@Param("start")int start, @Param("size")int size);

    Integer selectTagCount();
}
