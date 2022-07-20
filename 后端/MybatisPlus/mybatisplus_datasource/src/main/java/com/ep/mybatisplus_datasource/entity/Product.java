package com.ep.mybatisplus_datasource.entity;


import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {

    private Integer id;

    private String name;

    private Integer price;

    @Version
    private Integer version;
}
