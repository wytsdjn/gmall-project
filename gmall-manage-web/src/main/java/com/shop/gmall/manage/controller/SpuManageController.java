package com.shop.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.bean.BaseSaleAttr;
import com.shop.bean.SpuInfo;
import com.shop.bean.SpuSaleAttr;
import com.shop.gmall.service.SpuManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpuManageController {


    @Reference
    private SpuManageService spuManageService;


    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        spuManageService.saveSpuInfo(spuInfo);
        return "";
    }
    /**
     * 查询基本销售属性表
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        return spuManageService.getBaseSaleAttrList();
    }

}
