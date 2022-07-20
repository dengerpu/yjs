package com.ep.mybatisx_demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Product)表实体类
 *
 * @author makejava
 * @since 2022-07-20 16:05:08
 */
@SuppressWarnings("serial")
public class Product extends Model<Product> {
    //主键ID
    private Long id;
    //商品名称
    private String name;
    //价格
    private Integer price;
    //乐观锁版本号
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

