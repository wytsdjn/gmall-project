package com.shop.gmall.manage.mapper;

import com.shop.bean.SkuSaleAttrValue;
import com.shop.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue> {

    //根据spuid查询所有的skuSaleAttrValue
    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpuId(String spuId);
}
