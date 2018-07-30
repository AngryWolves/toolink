package com.angrywolves.tolink.controller;

import com.angrywolves.tolink.entity.AcctDetail;
import com.angrywolves.tolink.entity.Tag;
import com.angrywolves.tolink.framework.common.response.ResponseData;
import com.angrywolves.tolink.service.AcctService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 账目
 * Created by gf on 2018/7/23.
 */
@Controller
@RequestMapping("/v1/acct")
@Api(value = "/acct", description = "账目")
public class AcctController {

    @Autowired
    private AcctService acctService;

    //类别列表接口
    @ApiOperation(value="查询类别列表接口", notes="查询类别列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数(1开始)", required = true, paramType = "query", defaultValue = "1", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页行数", required = true, paramType = "query", defaultValue = "10", dataType = "int"),
    })
    @RequestMapping(value = "/queryAcctTypeList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryAcctTypeList(
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size
    ){
        ResponseData result = new ResponseData();

        int start = (page - 1) * size;
        result.setData(acctService.selectAcctType(start, size));
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    //添加记账接口
    @ApiOperation(value="添加记账接口", notes="添加记账接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "entity", required = true, paramType = "create", dataType = "AcctDetail"),
    })
    @RequestMapping(value = "/createAcctDetail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData createAcctDetail(@RequestBody AcctDetail entity){
        ResponseData result = new ResponseData();
        if (entity.getAcctTypeId() == null || entity.getAcctTypeId() == 0){
            result.setCode("500500");
            result.setMsg("账目类型id不能为空");
            return result;
        }
        if (BigDecimal.ZERO.equals(entity.getAmount()) || entity.getAmount() == null){
            result.setCode("500500");
            result.setMsg("账目金额不能为0");
            return result;
        }
        Integer integer = acctService.saveAcctDetail(entity);
        if (integer < 0){
            result.setCode("500501");
            result.setMsg("保存失败");
            return result;
        }
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    //查询记账接口
    @ApiOperation(value="查询记账接口", notes="查询记账接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数(1开始)", required = true, paramType = "query", defaultValue = "1", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页行数", required = true, paramType = "query", defaultValue = "10", dataType = "int"),
    })
    @RequestMapping(value = "/queryAcctDetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryAcctDetail(
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size
    ){
        ResponseData result = new ResponseData();

        int start = (page - 1) * size;
        result.setData(acctService.selectAcctDetailByUserId(0L , start, size));
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
}
