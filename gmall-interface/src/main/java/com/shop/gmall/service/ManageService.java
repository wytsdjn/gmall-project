package com.shop.gmall.service;

import com.shop.bean.*;

import java.util.List;

public interface ManageService {

    //查询所有一级分类
    List<BaseCatalog1> getCatalog1();
    //根据一级分类id查询二级分类
    List<BaseCatalog2> getCatalog2(String catalog1Id);
    //根据二级分类id查询三级分类
    List<BaseCatalog3> getCatalog3(String catalog2Id);
    //根据三级分类id查询平台属性 因为不多 所以不需要做分页
    List<BaseAttrInfo> getAttrInfo(String catalog3Id);
    //保存修改属性和属性值
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
    //根据属性id查询属性值集合
    List<BaseAttrValue> getAttrValueList(String attrId);
    //根据属性id查询属性
    BaseAttrInfo getAttrInfoByAttrId(String attrId);
}
