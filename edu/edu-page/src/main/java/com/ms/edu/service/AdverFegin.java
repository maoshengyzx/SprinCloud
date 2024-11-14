package com.ms.edu.service;

import com.ms.edu.entity.PromotionAd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName: AdverFegin
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 12:28
 * @Version 1.0
 */
@FeignClient(value = "edu-adver")
public interface AdverFegin {

    @GetMapping("/adver/getAdverList")
    public List<PromotionAd> getAdverList();

}
