package com.ep.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//为实体类型表名对应的数据库表名
//@TableName("t_user")
public class User {

    // 将属性对应的字段指定为主键
    //@TableId注解的value属性，指定表中的主键字段
    // @TableId
    //@TableId(value = "uid",type = IdType.AUTO)
    // 类型采用全局配置
    @TableId("uid")
    private Long id;

    // 指定属性所对应的字段名
    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    // 设置该字段为逻辑删除
    @TableLogic
    private Integer isDeleted;
}
