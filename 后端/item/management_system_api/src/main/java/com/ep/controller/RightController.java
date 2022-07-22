package com.ep.controller;

import com.ep.mapper.PermissionMapper;
import com.ep.pojo.Permission;
import com.ep.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RightController {

    @Autowired
    PermissionMapper permissionMapper;

    @GetMapping("rights/list")
    public ResultInfo findAllUser(){
        List<Permission> allRights = permissionMapper.findAllRights();
        if (allRights == null){
            return ResultInfo.fail(400,"请求失败");
        }else {
            return ResultInfo.success(allRights);
        }
    }
}
