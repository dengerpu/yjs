package com.ep.mybatisplus.service.impl;

import com.ep.mybatisplus.entity.User;
import com.ep.mybatisplus.mapper.UserMapper;
import com.ep.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dengerpu
 * @since 2022-07-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
