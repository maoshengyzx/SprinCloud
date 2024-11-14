package com.ms.edu.controller;

import com.ms.edu.entity.PromotionAd;
import com.ms.edu.service.AdverFegin;
import com.ms.edu.utils.ApiResponse;
import com.ms.edu.utils.RedisUtil;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
 * @Create 2024/6/11 13:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
@RefreshScope
public class AdverPageController {

    @Resource
    private AdverFegin adverFegin;

    @Resource
    private RedisUtil redisUtil;


    @GetMapping("/getAdver")
    public ApiResponse getAdver() {
        if (redisUtil.lGet("adverList", 0, 3).isEmpty()) {
            synchronized (this) {
                if (redisUtil.lGet("adverList", 0, 3).isEmpty()) {
                    List<PromotionAd> list = adverFegin.getAdverList();
                    return ApiResponse.success(list);
                }
            }
        }
        return ApiResponse.success(redisUtil.get("adverList"));
    }
}
