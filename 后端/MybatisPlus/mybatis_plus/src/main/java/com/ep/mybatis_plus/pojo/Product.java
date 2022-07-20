package com.ep.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    // 设置版本（乐观锁）
    @Version
    private Integer version;
}
