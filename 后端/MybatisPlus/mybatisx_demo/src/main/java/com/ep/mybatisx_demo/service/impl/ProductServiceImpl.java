package com.ep.mybatisx_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mybatisx_demo.dao.ProductDao;
import com.ep.mybatisx_demo.entity.Product;
import com.ep.mybatisx_demo.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2022-07-20 16:05:09
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}

