package com.execise.demo.scademopage.controller;

import com.execise.demo.common.utils.ApiResponse;
import com.execise.demo.scademopage.service.ProductFigen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: PageProductController
 * Package: com.execise.demo.scademopage.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/26 18:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class PageProductController {

    @Resource
    private ProductFigen productFigen;


    @GetMapping("/product/getProductList")
    public ApiResponse getProduct(){
        return ApiResponse.success(productFigen.getProduct());
    }
}
