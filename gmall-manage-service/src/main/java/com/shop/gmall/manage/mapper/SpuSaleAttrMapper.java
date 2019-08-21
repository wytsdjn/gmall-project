package com.shop.gmall.manage.mapper;

import com.shop.bean.SpuImage;
import com.shop.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {
    //根据spuid查询销售属性和属性值
    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    //根据skuid和spuid 查询销售属性和属性值
    List<SpuSaleAttr> getSaleAttrBySku(String skuId, String spuId);
}
