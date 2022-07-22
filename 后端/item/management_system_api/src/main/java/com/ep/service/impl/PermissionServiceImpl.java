package com.ep.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mapper.PermissionMapper;
import com.ep.pojo.Permission;
import com.ep.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> findAllRoles() {
        List<Permission> allRights = permissionMapper.findAllRights();
        return allRights;
    }
}
