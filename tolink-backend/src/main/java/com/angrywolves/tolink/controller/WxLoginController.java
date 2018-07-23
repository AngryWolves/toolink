package com.angrywolves.tolink.controller;

import com.alibaba.fastjson.JSONObject;
import com.angrywolves.tolink.entity.User;
import com.angrywolves.tolink.framework.common.response.ResponseData;
import com.angrywolves.tolink.framework.common.util.AesCbcUtil;
import com.angrywolves.tolink.framework.common.util.HttpRequest;
import com.angrywolves.tolink.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private UserService userService;

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
//        String openid = (String) json.get("openid");

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
