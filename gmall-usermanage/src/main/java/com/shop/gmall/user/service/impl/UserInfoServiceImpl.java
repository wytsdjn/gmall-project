package com.shop.gmall.user.service.impl;

import com.shop.bean.UserInfo;
import com.shop.gmall.service.UserInfoService;
import com.shop.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 实现获取所有用户信息列表
     * @return
     */
    @Override
    public List<UserInfo> getUserInfoList() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }
}
