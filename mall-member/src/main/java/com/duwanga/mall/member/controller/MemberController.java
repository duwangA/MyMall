package com.duwanga.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.duwanga.mall.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.duwanga.mall.member.entity.MemberEntity;
import com.duwanga.mall.member.service.MemberService;
import com.duwanga.common.utils.PageUtils;
import com.duwanga.common.utils.R;



/**
 * 会员
 *
 * @author duwanga
 * @email zzx451263@gmail.com
 * @date 2021-08-04 21:41:51
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    CouponFeignService couponFeignService;
    @GetMapping("/consumer/coupon")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setCity("GUANGDONG");
        memberEntity.setNickname("吴彦祖");
        R membercoupons = couponFeignService.membercoupons();
        Object o = membercoupons.get("coupons");
        return R.ok().put("member",memberEntity).put("coupons",o);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
