package com.duwanga.mall.member.dao;

import com.duwanga.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:41:51
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
