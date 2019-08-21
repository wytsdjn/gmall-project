package com.shop.gmall.service;

import com.shop.bean.*;

import java.util.List;

public interface SkuManageService {

    //保存sku信息
    void saveSkuInfo(SkuInfo skuInfo);

    //根据skuid查询详情页信息
    SkuInfo getItemInfoBySkuId(String skuId);

    //根据spuid查询所有的skuSaleAttrValue
    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpuId(String spuId);


}
