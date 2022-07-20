package com.ep.mybatisplus_datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ep.mybatisplus_datasource.mapper")
public class MybatisplusDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDatasourceApplication.class, args);
    }

}
