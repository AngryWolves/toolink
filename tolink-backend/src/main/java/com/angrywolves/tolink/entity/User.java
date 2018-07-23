package com.angrywolves.tolink.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * Created by gf on 2018/7/23.
 */
@ApiModel(description = "用户实体")
public class User implements Serializable{

    private Long id;

    @ApiModelProperty(name = "openId",value = "openId")
    private String openId;

    @ApiModelProperty(name = "userName",value = "名字")
    private String userName;

    @ApiModelProperty(name = "sex",value = "性别")
    private String sex;

    @ApiModelProperty(name = "age",value = "年龄")
    private String age;

    @ApiModelProperty(name = "regionProvince",value = "省")
    private String regionProvince;

    @ApiModelProperty(name = "regionCity",value = "市")
    private String regionCity;

    @ApiModelProperty(name = "regionDistrict",value = "区")
    private String regionDistrict;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public String getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(String regionCity) {
        this.regionCity = regionCity;
    }

    public String getRegionDistrict() {
        return regionDistrict;
    }

    public void setRegionDistrict(String regionDistrict) {
        this.regionDistrict = regionDistrict;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
