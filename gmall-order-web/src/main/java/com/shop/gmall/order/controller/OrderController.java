package com.shop.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.bean.UserAddress;
import com.shop.gmall.service.UserAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserAddressService userAddressService;

    /**
     * 根据用户id获取用户地址列表
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "getUserAddressListByUserId")
    @ResponseBody
    public List<UserAddress> getUserAddressListByUserId(UserAddress userAddress){
        return userAddressService.getUserAddressList(userAddress);
    }
}
