package com.shop.gmall.service;

import com.shop.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 获取用户信息列表
     * @return
     */
    List<UserInfo> getUserInfoList();
}
