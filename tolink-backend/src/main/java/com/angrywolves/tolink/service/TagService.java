package com.angrywolves.tolink.service;

import com.angrywolves.tolink.entity.Tag;
import com.angrywolves.tolink.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gf on 2018/7/23.
 */
@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    //保存标签
    public Integer saveTag(Tag entity){

        return tagMapper.saveTag(entity);
    }
}
