package com.ep.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ep.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findAllRights();

//    List<Permission> findAllRightsOne();
//
//    List<Permission> findAllRightsTwo(Integer pid);
//
//    List<Permission> findAllRightsThree(Integer pid);
}
