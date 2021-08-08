package com.duwanga.mall.coupon.dao;

import com.duwanga.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-05 15:20:29
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
