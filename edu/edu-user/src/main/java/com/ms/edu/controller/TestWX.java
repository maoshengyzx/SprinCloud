package com.ms.edu.controller;

import com.alibaba.fastjson.JSON;
import com.ms.edu.entity.User;
import com.ms.edu.httpclient.HttpClientUtil;
import com.ms.edu.mapper.UserMapper;
import com.ms.edu.utils.AppJwtUtil;
import com.ms.edu.wx.Token;
import com.ms.edu.wx.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TestWX {

    @Resource
    private UserMapper userMapper;

    private Map map = new HashMap();


    @GetMapping("/wxLogin")
    public String wxlogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String code) throws IOException {
        // 1.通过扫码去微信服务器请求，返回的code值
//        String code = request.getParameter("code");
        // 2.通过code获取access_token，定义获取access_token的url
        String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd99431bbff8305a0&secret=60f78681d063590a469f1b297feff3c4&code=" + code + "&grant_type=authorization_code";
        // 3.发请求并获得access_token
        String access_token = HttpClientUtil.doGet(getTokenUrl);
        System.out.println("access_token = " + access_token);
        // 4.将返回的json格式字符串转换成对象
        Token token = JSON.parseObject(access_token, Token.class);
        // 5.通过access_token获取获取微信用户个人信息
        String getUserUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token.getAccess_token() + "&openid=" + token.getOpenid();
        // 6.发请求并获取用户信息
        String user_token = HttpClientUtil.doGet(getUserUrl);
        // 7.将返回的json格式字符串转换成对象
        UserInfo userInfo = JSON.parseObject(user_token, UserInfo.class);
        User i = userMapper.selectByRegIp(userInfo.getOpenid());
        if (i == null) {
            User user = new User();
            user.setName(userInfo.getNickname());
            user.setPortrait(userInfo.getHeadimgurl());
            user.setRegIp(userInfo.getOpenid());
            userMapper.insert(user);
            String s = AppJwtUtil.getToken(user.getId().longValue());
            map.put("userInfo", user);
            map.put("token", s);
        } else {
            map.put("userInfo", i);
            map.put("token", AppJwtUtil.getToken(i.getId().longValue()));
        }
        return "http://localhost:8080";
    }

    @GetMapping("checkWxStatus")
    public Map checkWxStatus() {
        return this.map;
    }

    @GetMapping("logout")
    public Object logout() {
        this.map = null;
        return null;
    }
}