package com.ep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mapper.PermissionMapper;
import com.ep.mapper.RoleMapper;
import com.ep.pojo.Permission;
import com.ep.pojo.Role;
import com.ep.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> findAllRoles() {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("role_id","role_name","role_desc");
        List<Role> roles = list(queryWrapper);
        return roles;
    }

    @Override
    public List<Role> findAllRolesAndPermission() {
//        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("role_id","role_name","role_desc","ps_ids");
//        List<Role> list = list(queryWrapper);
//        for (int i = 0; i < list.size(); i++) {
//            List<String> asList = Arrays.asList(list.get(i).getPsIds().split(","));
//            list.get(i).setIds(asList);
//        }
//        List<Permission> allRightsOne = permissionMapper.findAllRightsOne();
//        System.out.println(allRightsOne);
        return null;
    }
}
