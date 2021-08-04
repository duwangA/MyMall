package com.duwanga.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duwanga.mall.product.entity.BrandEntity;
import com.duwanga.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setLogo("美人鱼");
//        brandEntity.setDescript("coffee");
//        brandEntity.setName("starbucks");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");
//        brandService.updateById(brandEntity);
        BrandEntity brand_id = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        System.out.println(brand_id);
    }

}
