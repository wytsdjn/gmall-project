package com.shop.gmall.manage.mapper;

import com.shop.bean.BaseAttrInfo;
import com.shop.bean.BaseCatalog1;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo>{

    //根据三级分类id查询所有的属性
    List<BaseAttrInfo> getAttrInfo(String catalog3Id);

}
