package com.angrywolves.tolink.service;

import com.angrywolves.tolink.entity.User;
import com.angrywolves.tolink.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gf on 2018/7/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //保存用户授权登陆信息
    public Integer saveUser(User entity){

        return userMapper.saveUser(entity);
    }
}
