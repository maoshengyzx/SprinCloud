package com.ms.edu.service;

import com.ms.edu.config.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "edu-user", configuration = FeignSupportConfig.class,contextId = "UploadClient")
public interface UploadClient {

    @PostMapping(value = "/user/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file, @RequestParam int userId);

}