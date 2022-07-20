package com.ep.mybatisplus_datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mybatisplus_datasource.entity.User;
import com.ep.mybatisplus_datasource.mapper.UserMapper;
import com.ep.mybatisplus_datasource.service.UserService;
import org.springframework.stereotype.Service;

@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
