package com.duwanga.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:54:50
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

