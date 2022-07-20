package com.ep.mybatisplus_datasource.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId(value = "uid")
    private Integer uid;

    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    private Integer isDeleted;

    private Integer sex;

}
