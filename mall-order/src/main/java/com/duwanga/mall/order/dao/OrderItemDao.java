package com.duwanga.mall.order.dao;

import com.duwanga.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:51:00
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
