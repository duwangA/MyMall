package com.duwanga.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.mall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:51:00
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

