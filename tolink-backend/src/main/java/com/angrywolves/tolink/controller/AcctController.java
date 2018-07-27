package com.angrywolves.tolink.controller;

import com.angrywolves.tolink.framework.common.response.ResponseData;
import com.angrywolves.tolink.service.AcctService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ApiOperation(value="查询平台管理成本列表", notes="查询平台管理成本列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数(1开始)", required = true, paramType = "query", defaultValue = "1", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页行数", required = true, paramType = "query", defaultValue = "10", dataType = "int"),
    })
    @RequestMapping(value = "/queryAccttypeList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryAccttypeList(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", required = true, defaultValue = "10") Integer size){
        ResponseData result = new ResponseData();

        int start = (page - 1) * size;
        result.setData(acctService.selectAcctType(start, size));
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    //添加记账接口

    //查询记账接口
}
