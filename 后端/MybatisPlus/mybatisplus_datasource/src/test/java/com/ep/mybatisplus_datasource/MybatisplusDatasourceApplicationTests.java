package com.ep.mybatisplus_datasource;

import com.ep.mybatisplus_datasource.entity.Product;
import com.ep.mybatisplus_datasource.entity.User;
import com.ep.mybatisplus_datasource.service.ProductService;
import com.ep.mybatisplus_datasource.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class MybatisplusDatasourceApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void testDataSource() {
        User user = userService.getById(1);
        Product product = productService.getById(1);
        System.out.println(user);
        System.out.println(product);
    }

}
