package com.shop.gmall.service;

import com.shop.bean.BaseSaleAttr;
import com.shop.bean.SpuImage;
import com.shop.bean.SpuInfo;
import com.shop.bean.SpuSaleAttr;

import java.util.List;

public interface SpuManageService {

    // 查询基本销售属性表
    List<BaseSaleAttr> getBaseSaleAttrList();

    //保存sku信息
    public void saveSpuInfo(SpuInfo spuInfo);

    //根据spuid查询spu图片
    List<SpuImage> spuImageList(SpuImage spuImage);

    //根据spuid查询销售属性和属性值
    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    //根据skuid和spuid 查询销售属性和属性值 用于商品详情显示
    List<SpuSaleAttr> getSaleAttrBySku(String skuId, String spuId);
}
