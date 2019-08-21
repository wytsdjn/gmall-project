package com.shop.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.shop.bean.SkuInfo;
import com.shop.bean.SkuSaleAttrValue;
import com.shop.bean.SpuInfo;
import com.shop.bean.SpuSaleAttr;
import com.shop.gmall.service.SkuManageService;
import com.shop.gmall.service.SpuManageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {


    @Reference
    private SkuManageService skuManageService;

    @Reference
    private SpuManageService spuManageService;

    /**
     * 显示商品详情信息
     * @param skuId
     * @param model
     * @return
     */
    @RequestMapping("{skuId}.html")
    public String getItemInfoBySkuId(@PathVariable(value = "skuId") String skuId, Model model){

        //根据skuid查询skuinfo表中sku的基本信息
        SkuInfo skuInfo = skuManageService.getItemInfoBySkuId(skuId);
        model.addAttribute("skuInfo",skuInfo);

        //根据skuid和spuid查询sku的销售属性和销售属性值
        List<SpuSaleAttr> spuSaleAttrList = spuManageService.getSaleAttrBySku(skuId,skuInfo.getSpuId());
        model.addAttribute("spuSaleAttrList",spuSaleAttrList);

        //查询销售属性值 返回一个skuSaleAttrValue集合
        List<SkuSaleAttrValue> skuSaleAttrValueList = skuManageService.getSkuSaleAttrValueListBySpuId(skuInfo.getSpuId());
        //把列表变换成 valueid1|valueid2|valueid3 ：skuId  的 哈希表 用于在页面中定位查询
        String valueIdsKey="";
        Map<String,String> valuesSkuMap=new HashMap<>();

        for (int i = 0; i < skuSaleAttrValueList.size(); i++) {
            SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueList.get(i);
            //拼接key值
            if (valueIdsKey.length()!=0) {
                //说明不是第一次拼接
                valueIdsKey+="|";
            }
            valueIdsKey+=skuSaleAttrValue.getSaleAttrValueId();
            //不拼接的情况 假如可以循环到最后 超出集合大小 或者 当前的skuid和下一个skuid不相等 也就是换了一个sku
            if ((i+1)==skuSaleAttrValueList.size() || !skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueList.get(i+1).getSkuId())) {
                //当前的组合拼接完毕 放入map中
                valuesSkuMap.put(valueIdsKey,skuSaleAttrValue.getSkuId());
                //开始下一次循环前 清空key
                valueIdsKey="";
            }
        }
        //将map对象转换成json串
        String toJSONString = JSON.toJSONString(valuesSkuMap);
        model.addAttribute("valuesSku",toJSONString);

        return "item";
    }
}
