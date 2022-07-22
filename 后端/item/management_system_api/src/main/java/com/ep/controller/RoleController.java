package com.ep.controller;


import com.ep.pojo.Role;
import com.ep.service.RoleService;
import com.ep.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResultInfo findAllRoles(){
        List<Role> allRoles = roleService.findAllRoles();
        if (allRoles !=null ) {
            return ResultInfo.success(allRoles);
        }else {
            return ResultInfo.fail(422,"查询失败");
        }
    }
}
