package com.shop.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.bean.UserAddress;
import com.shop.gmall.service.UserAddressService;
import com.shop.gmall.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 根据用户id获取用户地址列表
     * @param userAddress
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(UserAddress userAddress) {

        return userAddressMapper.select(userAddress);
    }
}
