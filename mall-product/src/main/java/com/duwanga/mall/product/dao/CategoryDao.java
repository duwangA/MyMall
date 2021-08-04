package com.duwanga.mall.product.dao;

import com.duwanga.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 20:02:28
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
