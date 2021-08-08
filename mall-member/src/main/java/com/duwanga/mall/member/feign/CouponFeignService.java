package com.duwanga.mall.member.feign;

import com.duwanga.common.utils.R;
import com.duwanga.mall.member.feign.Impl.CouponFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@FeignClient(value = "mall-coupon",fallback = CouponFeignServiceImpl.class)
public interface CouponFeignService {

    @GetMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
