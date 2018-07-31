package com.angrywolves.tolink.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.angrywolves.tolink.entity.User;
import com.angrywolves.tolink.framework.common.response.ResponseData;
import com.angrywolves.tolink.framework.common.util.AesCbcUtil;
import com.angrywolves.tolink.framework.common.util.HttpRequest;
import com.angrywolves.tolink.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by gf on 2018/7/23.
 */
@Controller
@RequestMapping("/v1/weixin")
@Api(value = "/weixin", description = "微信授权登陆")
public class WxLoginController {

    //小程序唯一标识   (在微信小程序管理后台获取)
    String wxspAppid = "xxxxxxxxxxxxxx";
    //小程序的 app secret (在微信小程序管理后台获取)
    String wxspSecret = "xxxxxxxxxxxxxx";
    //授权（必填）
    String grant_type = "authorization_code";
    //地址
    String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private UserService userService;

    /**
     * 获取微信小程序 session_key 和 openid
     * @param code 调用微信登陆返回的Code
     * @return
     */
    @ApiOperation(value="获取微信小程序session_key和openid", notes="调用微信登陆返回的Code")
    @RequestMapping(value = "/getSessionKeyOropenid", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getSessionKeyOropenid(String code) {
        ResponseData result = new ResponseData();
        //微信端登录code值,String wxCode = code;
        if (StringUtils.isEmpty(code)){
            result.setCode("500500");
            result.setMsg("code为空");
            return result;
        }
        //请求地址 https://api.weixin.qq.com/sns/jscode2session
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", wxspAppid);  //开发者设置中的appId
        requestUrlParam.put("secret", wxspSecret); //开发者设置中的appSecret
        requestUrlParam.put("js_code", code); //小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", grant_type);    //默认参数 authorization_code

        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpRequest.sendPost(requestUrl, requestUrlParam));
        result.setData(jsonObject);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    @ApiOperation(value="登陆接口", notes="登陆接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData decodeUserInfo(String encryptedData, String iv, String code){
        ResponseData result = new ResponseData();

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            result.setCode("500500");
            result.setMsg("code不能为空");
            return result;
        }
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        //String openid = (String) json.get("openid");

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String res = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != res && res.length() > 0) {
                JSONObject userInfoJSON = JSONObject.parseObject(res);
                User user = new User();
                user.setOpenId(userInfoJSON.get("openId").toString());
                user.setUserName(userInfoJSON.get("nickName").toString());
                user.setSex(userInfoJSON.get("gender").toString());
                user.setRegionProvince(userInfoJSON.get("province").toString());
                user.setRegionCity(userInfoJSON.get("city").toString());
                user.setRegionDistrict(userInfoJSON.get("country").toString());

                Integer integer = userService.saveUser(user);
                if (integer < 0){
                    result.setCode("500500");
                    result.setMsg("error");
                    return result;
                }
                result.setData(user);
                result.setCode("200");
                result.setMsg("success");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setCode("500500");
        result.setMsg("error");
        return result;
    }
}
