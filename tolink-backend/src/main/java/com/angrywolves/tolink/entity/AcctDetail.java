package com.angrywolves.tolink.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账目内容
 * Created by gf on 2018/7/23.
 */
@ApiModel(description = "账目内容实体")
public class AcctDetail implements Serializable{

    private Long id;

    @ApiModelProperty(name = "userId",value = "用户id")
    private Long userId;

    @ApiModelProperty(name = "acctTypeId",value = "账目类型id")
    private Long acctTypeId;

    @ApiModelProperty(name = "amount",value = "金额")
    private BigDecimal amount;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;
}
