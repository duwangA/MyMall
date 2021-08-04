package com.duwanga.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.mall.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:28:25
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

