package com.duwanga.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:51:00
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

