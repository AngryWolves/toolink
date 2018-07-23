package com.angrywolves.tolink.entity;

import java.io.Serializable;

/**
 * 1.类别列表接口
 2.添加记账接口
 3.查询记账接口
 4.添加标签接口
 */
public class Demo implements Serializable{

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
