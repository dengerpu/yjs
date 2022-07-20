package com.ep.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ep.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {

    /**
     * 登陆
     * @param username 账号
     * @param password 密码
     * @return
     */
    User Login(String username, String password);
}
