package com.shop.gmall.user.controller;

import com.shop.bean.UserInfo;
import com.shop.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value="getAllUserInfo")
    @ResponseBody
    public List<UserInfo> getAllUserInfo(){

        return userInfoService.getUserInfoList();
    }
}
