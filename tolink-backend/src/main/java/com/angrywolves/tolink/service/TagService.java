package com.angrywolves.tolink.service;

import com.angrywolves.tolink.entity.Tag;
import com.angrywolves.tolink.framework.common.response.QueryResult;
import com.angrywolves.tolink.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //查询
    public QueryResult<Tag> selectTag(int start, int size){
        QueryResult<Tag> result = new QueryResult<Tag>();

        List<Tag> lists = tagMapper.selectTag(start, size);
        Integer total = tagMapper.selectTagCount();

        result.setRows(lists);
        result.setTotal(total.toString());
        return result;
    }
}
