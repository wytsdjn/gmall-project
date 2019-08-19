package com.shop.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.bean.*;
import com.shop.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;



    /**
     * 根据三级分类id查询spu
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    public List<SpuInfo> getSpuInfoList(String catalog3Id){
        return manageService.getSpuInfoList(catalog3Id);
    }
    /**
     * 根据属性id 查询属性值 回显数据
     * @param attrId
     * @return
     */
    @RequestMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        BaseAttrInfo baseAttrInfo = manageService.getAttrInfoByAttrId(attrId);
        return baseAttrInfo.getAttrValueList();
    }
    /**
     * 保存或者修改属性和属性值
     * @param baseAttrInfo
     */
    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }

    /**
     * 查询所有的一级分类
     * @return
     */
    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }

    /**
     * 根据一级分类id查询二级分类
     * @param catalog1Id
     * @return
     */
    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2(catalog1Id);
    }

    /**
     * 根据二级分类id查询三级分类
     * @param catalog2Id
     * @return
     */
    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3(catalog2Id);
    }

    /**
     * 根据三级分类id查询属性列表
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id){
        return manageService.getAttrInfo(catalog3Id);
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }


}
