package com.ms.edu.controller;

import com.ms.edu.utils.RedisUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: XxlJob
 * Package: com.ms.edu
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 19:33
 * @Version 1.0
 */
@Component
public class XxlJobController {

    @Resource
    private RedisUtil redisUtil;

    @XxlJob("csJob")
    public ReturnT<String> execute(String param) {
        redisUtil.lRemove("adverList", 0, null);
        return new ReturnT<>(String.valueOf(System.currentTimeMillis()));
    }

}
