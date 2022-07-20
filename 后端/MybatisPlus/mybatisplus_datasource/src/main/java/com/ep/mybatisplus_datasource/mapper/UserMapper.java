package com.ep.mybatisplus_datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ep.mybatisplus_datasource.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User findUser();
}
