package com.ep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ep.mapper")
public class ManagementSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementSystemApiApplication.class, args);
    }

}
