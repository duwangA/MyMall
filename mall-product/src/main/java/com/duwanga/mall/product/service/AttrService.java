package com.duwanga.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 20:02:28
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

