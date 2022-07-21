package com.ep.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Role {

    @TableId("role_id")
    private Integer id;

    private String roleName;

    private String roleDesc;
}
