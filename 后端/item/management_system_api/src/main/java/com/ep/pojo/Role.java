package com.ep.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Role {

    @TableId("role_id")
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private String psIds;

    private List<String> ids;

    private List<Permission> chidren;
}
