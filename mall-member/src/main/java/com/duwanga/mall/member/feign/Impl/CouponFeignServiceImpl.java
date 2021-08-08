package com.duwanga.mall.member.feign.Impl;

import com.duwanga.common.utils.R;
import com.duwanga.mall.member.feign.CouponFeignService;
import org.springframework.stereotype.Component;

@Component
public class CouponFeignServiceImpl implements CouponFeignService {
    @Override
    public R membercoupons() {
        return R.ok().put("错误信息","fall back /(ㄒoㄒ)/~~");
    }
}
