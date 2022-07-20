package com.ep.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    @TableField("role_id")
    private String rid;

    private String token;

    private Integer state;




}
