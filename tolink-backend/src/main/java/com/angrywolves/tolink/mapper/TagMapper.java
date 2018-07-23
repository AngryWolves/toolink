package com.angrywolves.tolink.mapper;

import com.angrywolves.tolink.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 标签
 * Created by gf on 2018/7/23.
 */
@Mapper
@Component
public interface TagMapper {

    //保存
    Integer saveTag(Tag entity);
}
