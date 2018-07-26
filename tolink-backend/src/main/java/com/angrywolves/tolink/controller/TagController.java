package com.angrywolves.tolink.controller;

import com.angrywolves.tolink.entity.Tag;
import com.angrywolves.tolink.framework.common.response.ResponseData;
import com.angrywolves.tolink.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gf on 2018/7/23.
 */
@Controller
@RequestMapping("/v1/tag")
@Api(value = "/tag", description = "标签")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value="添加标签接口", notes="添加标签接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "entity", required = true, paramType = "create", dataType = "Tag"),
    })
    @RequestMapping(value = "/createTag", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData createTag(@RequestBody Tag entity){
        ResponseData result = new ResponseData();
        if (StringUtils.isEmpty(entity.getTagName())){
            result.setCode("500500");
            result.setMsg("标签名称不能为空");
            return result;
        }
        Integer integer = tagService.saveTag(entity);
        if (integer < 0){
            result.setCode("500501");
            result.setMsg("error");
            return result;
        }
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
}
