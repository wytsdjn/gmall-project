package com.shop.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.bean.*;
import com.shop.gmall.manage.mapper.*;
import com.shop.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService{

    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    /**
     * 查询所有一级分类
     * @return
     */
    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    /**
     * 根据一级分类id查询二级分类
     * @param catalog1Id
     * @return
     */
    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    /**
     * 根据二级分类id查询三级分类
     * @param catalog2Id
     * @return
     */
    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    /**
     * 根据三级分类id查询所有的属性
     * @param catalog3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfo(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    /**
     * 添加或者修改属性和属性值
     * @param baseAttrInfo
     */
    @Transactional
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo!=null&& !StringUtils.isEmpty(baseAttrInfo.getId())) {
            //有属性id 进行修改属性
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }else {
            //添加属性
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }

        //添加或者修改属性值

        //得到属性值集合
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        //添加之前先将原数据删除
        BaseAttrValue attrValue = new BaseAttrValue();
        attrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(attrValue);

        //再重新插入数据
        if (attrValueList!=null&&attrValueList.size()>0) {//先判断是否为空 可以避免空指针
            for (BaseAttrValue baseAttrValue : attrValueList) {
                //valueName是前台传的值 只有attrId需要设置
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(baseAttrValue);
            }
        }
    }

    /**
     * 根据属性id查询属性值集合
     * @param attrId
     * @return
     */
    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> attrValueList = baseAttrValueMapper.select(baseAttrValue);
        return attrValueList;
    }

    /**
     * 根据属性id查询属性 封装属性值 返回数据 用于回显
     * @param attrId
     * @return
     */
    @Override
    public BaseAttrInfo getAttrInfoByAttrId(String attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        baseAttrInfo.setAttrValueList(this.getAttrValueList(attrId));
        return baseAttrInfo;
    }
}
