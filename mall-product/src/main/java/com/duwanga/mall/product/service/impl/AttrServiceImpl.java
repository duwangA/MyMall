package com.duwanga.mall.product.service.impl;

import com.duwanga.mall.product.dao.AttrAttrgroupRelationDao;
import com.duwanga.mall.product.dao.AttrGroupDao;
import com.duwanga.mall.product.dao.CategoryDao;
import com.duwanga.mall.product.entity.AttrAttrgroupRelationEntity;
import com.duwanga.mall.product.entity.AttrGroupEntity;
import com.duwanga.mall.product.entity.CategoryEntity;
import com.duwanga.mall.product.vo.AttrResponseVo;
import com.duwanga.mall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.common.utils.Query;

import com.duwanga.mall.product.dao.AttrDao;
import com.duwanga.mall.product.entity.AttrEntity;
import com.duwanga.mall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    AttrGroupDao groupDao;

    @Autowired
    CategoryDao categoryDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        //保存基本数据
        this.save(attrEntity);
        //保存关联关系数据
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrGroupId(attr.getAttrGroupId());
        relationEntity.setAttrId(attrEntity.getAttrId());
        attrAttrgroupRelationDao.insert(relationEntity);
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>();

        if (catelogId != 0){
            wrapper.eq("catelog_id",catelogId);
        }
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)){
            wrapper.and((obj)->{
               obj.eq("attr_id",key).or().like("attr_name",key);
            });
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),wrapper);

        PageUtils pageFinal = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrResponseVo> responseVos = records.stream().map((attrEntity) -> {
            AttrResponseVo responseVo = new AttrResponseVo();
            //拷贝基本属性
            BeanUtils.copyProperties(attrEntity, responseVo);
            //设置分类分组的名字
//            System.out.println("attrGroup========"+attrEntity.ge());
            //1.先从中间表查groupid,再用groupId在group表查name
            AttrAttrgroupRelationEntity relationEntity = attrAttrgroupRelationDao.selectById(attrEntity.getAttrId());
            Long attrGroupId = relationEntity.getAttrGroupId();
            AttrGroupEntity attrGroupEntity = groupDao.selectById(attrGroupId);
            String groupName = attrGroupEntity.getAttrGroupName();
            System.out.println(groupName);
            if (groupName != null) {
                responseVo.setGroupName(groupName);
            }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());

            String categoryEntityName = categoryEntity.getName();
            if (categoryEntityName != null) {
                responseVo.setCatelogName(categoryEntityName);
            }

            return responseVo;
        }).collect(Collectors.toList());
        pageFinal.setList(responseVos);
        return  pageFinal;
    }

}