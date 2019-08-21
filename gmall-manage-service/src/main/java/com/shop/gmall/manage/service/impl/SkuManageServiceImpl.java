package com.shop.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.bean.*;
import com.shop.gmall.manage.mapper.SkuAttrValueMapper;
import com.shop.gmall.manage.mapper.SkuImageMapper;
import com.shop.gmall.manage.mapper.SkuInfoMapper;
import com.shop.gmall.manage.mapper.SkuSaleAttrValueMapper;
import com.shop.gmall.service.SkuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkuManageServiceImpl implements SkuManageService {

    @Autowired
    private SkuImageMapper skuImageMapper;

    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    private SkuInfoMapper skuInfoMapper;


    @Override
    @Transactional
    public void saveSkuInfo(SkuInfo skuInfo) {
        if (skuInfo!=null) {
            skuInfoMapper.insertSelective(skuInfo);

            //保存图片
            List<SkuImage> skuImageList = skuInfo.getSkuImageList();
            if (skuImageList!=null && skuImageList.size()>0 ) {
                for (SkuImage skuImage : skuImageList) {
                    skuImage.setSkuId(skuInfo.getId());
                    skuImageMapper.insertSelective(skuImage);
                }
            }
            //保存销售属性
            List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
            if (skuAttrValueList!=null && skuAttrValueList.size()>0) {
                for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                    skuAttrValue.setSkuId(skuInfo.getId());
                    skuAttrValueMapper.insertSelective(skuAttrValue);
                }
            }
            //保存销售属性值
            List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            if (skuSaleAttrValueList!=null && skuSaleAttrValueList.size()>0) {
                for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                    skuSaleAttrValue.setSkuId(skuInfo.getId());
                    skuSaleAttrValueMapper.insertSelective(skuSaleAttrValue);
                }
            }
        }
    }

    /**
     * 根据skuid查询skuinfo详情信息
     * @param skuId
     * @return
     */
    @Override
    public SkuInfo getItemInfoBySkuId(String skuId) {
        //查询skuInfo表
        SkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(skuId);
        if (skuInfo!=null) {
            //查询图片信息
            SkuImage skuImage = new SkuImage();
            skuImage.setSkuId(skuId);
            List<SkuImage> skuImageList = skuImageMapper.select(skuImage);
            skuInfo.setSkuImageList(skuImageList);
        }
        return skuInfo;
    }

    /**
     * 根据spuid查询所有的skuSaleAttrValue
     * @param spuId
     * @return
     */
    @Override
    public List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpuId(String spuId) {
        return skuSaleAttrValueMapper.getSkuSaleAttrValueListBySpuId(spuId);
    }


}
