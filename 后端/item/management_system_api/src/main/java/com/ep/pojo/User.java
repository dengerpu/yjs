package com.ep.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    @TableField("role_id")
    private String rid;

    @TableField(exist = false)
    private String token;

    private Boolean state;

    private String mobile;

    private String email;

    @TableField(exist = false)
    private String roleName;

    @TableField(exist = false)
    private Date createTime;
}
