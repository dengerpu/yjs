package com.ep.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ep.pojo.Permission;
import com.ep.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<Permission> findAllPermission();
}
