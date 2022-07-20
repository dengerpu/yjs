package com.ep.mybatisplus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mybatisplus_datasource.entity.Product;
import com.ep.mybatisplus_datasource.mapper.ProductMapper;
import com.ep.mybatisplus_datasource.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService{
}
