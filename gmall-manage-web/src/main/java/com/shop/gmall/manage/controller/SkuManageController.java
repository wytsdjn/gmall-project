package com.shop.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.bean.SkuImage;
import com.shop.bean.SkuInfo;
import com.shop.gmall.service.SkuManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SkuManageController {


    @Reference
    private SkuManageService skuManageService;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody SkuInfo skuInfo){
        skuManageService.saveSkuInfo(skuInfo);
        return "wyt";
    }
}
