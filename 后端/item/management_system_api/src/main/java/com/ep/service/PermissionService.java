package com.ep.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ep.pojo.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService extends IService<Permission> {

    List<Permission> findAllRoles();
}
