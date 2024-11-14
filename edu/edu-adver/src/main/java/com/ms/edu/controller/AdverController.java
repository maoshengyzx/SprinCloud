package com.ms.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ms.edu.entity.PromotionAd;
import com.ms.edu.mapper.PromotionAdMapper;
import com.ms.edu.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: AdverController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 13:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/adver")
public class AdverController {

    @Resource
    private PromotionAdMapper promotionAdMapper;

    @Resource
    private RedisUtil redisUtil;


    @GetMapping("getAdverList")
    public List<PromotionAd> getAdverList(){
        List<PromotionAd> list = promotionAdMapper.selectList(null);
        redisUtil.lSet("adverList", list);
        return list;
    }
}
