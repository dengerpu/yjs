package com.ep.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Permission {

    @TableId("ps_id")
    private Integer psId;


    private String psName;


    private String psLevel;

    private String path;

    private List<Permission> children;
}
