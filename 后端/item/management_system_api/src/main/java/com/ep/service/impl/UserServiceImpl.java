package com.ep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.domain.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User Login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id").select("role_id").select("username").select("mobile").select("email");
        queryWrapper.eq("username",username)
                .eq("password",password);
        User user = getOne(queryWrapper);
        return user;
    }
}
