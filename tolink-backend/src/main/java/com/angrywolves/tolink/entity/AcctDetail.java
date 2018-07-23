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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAcctTypeId() {
        return acctTypeId;
    }

    public void setAcctTypeId(Long acctTypeId) {
        this.acctTypeId = acctTypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
