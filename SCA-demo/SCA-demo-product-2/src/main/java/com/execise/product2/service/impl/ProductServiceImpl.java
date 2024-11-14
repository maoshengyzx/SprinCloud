package com.execise.product2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.execise.demo.common.entity.Product;
import com.execise.product2.service.ProductService;
import com.execise.product2.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【product】的数据库操作Service实现
* @createDate 2024-06-26 18:44:18
*/
@Service("productService2")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




