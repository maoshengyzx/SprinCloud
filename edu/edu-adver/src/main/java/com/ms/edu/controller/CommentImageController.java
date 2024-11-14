package com.ms.edu.controller;


import com.ms.edu.oss.AliOSSUtils;
import com.ms.edu.utils.ApiResponse;
import com.ms.edu.utils.RedisUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * (CommentImage)表控制层
 *
 * @author makejava
 * @since 2024-04-24 18:32:23
 */
@RestController
@RequestMapping("commentImage")
public class CommentImageController {


    @Resource
    private RedisUtil redisUtil;


    /**
     * 景点 图片上传 并存到阿里云校
     *
     * @return 新增结果
     */
    @PostMapping("/common/upload/scenicspot")
    public ApiResponse uploadImageScecicspot(@RequestParam("file") MultipartFile[] multipartFile, HttpServletRequest request) throws IOException {
        ArrayList list = new ArrayList();
        for (MultipartFile file : multipartFile) {
            if (!file.isEmpty()) {
                InputStream inputStream = file.getInputStream();
                //String avatar = FileUploadUtils.upload(ibackConfig.getAvatarPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
                String avatar = AliOSSUtils.UploadOSS("WindImage/" + file.getOriginalFilename(), inputStream);
                System.out.println(avatar);
                list.add(avatar);
            }
        }
        return ApiResponse.success(list);
//        return ApiResponse.fail(500, "上传图片异常，请联系管理员");
    }



}

