package com.shop.gmall.service;

import com.shop.bean.UserAddress;

import java.util.List;

public interface UserAddressService {

    //根据用户id获取用户地址列表
    List<UserAddress> getUserAddressList(UserAddress userAddress);
}
