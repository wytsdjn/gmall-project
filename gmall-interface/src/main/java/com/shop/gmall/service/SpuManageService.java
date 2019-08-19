package com.shop.gmall.service;

import com.shop.bean.BaseSaleAttr;
import com.shop.bean.SpuInfo;
import com.shop.bean.SpuSaleAttr;

import java.util.List;

public interface SpuManageService {

    // 查询基本销售属性表
    List<BaseSaleAttr> getBaseSaleAttrList();

    //保存sku信息
    public void saveSpuInfo(SpuInfo spuInfo);
}
