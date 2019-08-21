package com.shop.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.bean.*;
import com.shop.gmall.service.SpuManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpuManageController {


    @Reference
    private SpuManageService spuManageService;


    /**
     * 根据spuid查询销售属性和属性值
     * @param spuId
     * @return
     */
    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){

        return spuManageService.spuSaleAttrList(spuId);
    }
    /**
     * 根据spuid 查询spu图片
     * @param spuImage
     * @return
     */
    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(SpuImage spuImage){
        if (spuImage!=null) {
            return spuManageService.spuImageList(spuImage);
        }
        return null;
    }
    /**
     * 保存spuInfo
     * @param spuInfo
     * @return
     */
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
