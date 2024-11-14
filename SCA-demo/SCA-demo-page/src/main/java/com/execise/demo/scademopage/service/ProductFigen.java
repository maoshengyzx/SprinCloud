package com.execise.demo.scademopage.service;

import com.execise.demo.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName: ProductFigen
 * Package: com.execise.demo.scademopage.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/26 18:52
 * @Version 1.0
 */
@FeignClient("sca-demo-product")
public interface ProductFigen {

    @GetMapping("/product/getProductList")
    public List<Product> getProduct();
}
