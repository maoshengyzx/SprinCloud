package com.execise.product.controller;

import com.execise.demo.common.entity.Product;
import com.execise.product.mapper.ProductMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: ProductController
 * Package: com.execise.demo.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/26 18:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductMapper productMapper;


    @GetMapping("/getProductList")
    public List<Product> getProductList() {
        System.out.println(9003);
        return productMapper.selectList(null);
    }
}
