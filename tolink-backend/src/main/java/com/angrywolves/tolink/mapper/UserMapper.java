package com.angrywolves.tolink.mapper;

import com.angrywolves.tolink.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by gf on 2018/7/23.
 */
@Mapper
@Component
public interface UserMapper {

    //保存
    Integer saveUser(User entity);
}
