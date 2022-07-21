package com.ep.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ep.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService extends IService<Role> {

    /***
     * 查找所有角色
     * @return
     */
    List<Role> findAllRoles();
}
