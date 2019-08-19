package com.shop.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.bean.*;
import com.shop.gmall.manage.mapper.*;
import com.shop.gmall.service.SpuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.net.PortUnreachableException;
import java.util.List;

@Service
public class SpuManageServiceImpl implements SpuManageService {


    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    private SpuImageMapper spuImageMapper;
    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;

    /**
     * 查询基本销售属性表
     * @return
     */
    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    /**
     * 保存sku信息
     * spuInfo : 商品表
     * spuSaleAttr: 销售属性
     * spuSaleAttrValue: 销售属性值
     * spuImage: 商品图片
     * spuPoster: 海报
     * @param spuInfo
     */
    @Override
    @Transactional
    public void saveSpuInfo(SpuInfo spuInfo) {
        //保存商品信息
        if (spuInfo!=null) {
            spuInfoMapper.insertSelective(spuInfo);
        }
        //保存商品图片信息
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList!=null && spuImageList.size()>0) {
            for (SpuImage spuImage : spuImageList) {
                spuImageMapper.insertSelective(spuImage);
            }
        }
        //保存销售属性信息
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList!=null && spuSaleAttrList.size()>0) {
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
                //设置商品id  其他的前台传值
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insertSelective(spuSaleAttr);

                //保存销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if (spuSaleAttrValueList!=null && spuSaleAttrValueList.size()>0) {
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                        //设置商品id 其他的前台传值
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValueMapper.insertSelective(spuSaleAttrValue);
                    }
                }
            }
        }

    }
}
