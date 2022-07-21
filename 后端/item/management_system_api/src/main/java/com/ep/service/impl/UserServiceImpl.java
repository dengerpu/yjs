package com.ep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.jwt.JwtUtil;
import com.ep.pojo.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import com.ep.vo.PageBean;
import com.ep.vo.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo Login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username)
                .eq("password",password);
        User user = getOne(queryWrapper);
        UserInfo userInfo = new UserInfo();
        if(user != null){
            String token = JwtUtil.createToken(user);
            user.setToken(token);
        }
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }


    @Override
    public Page<User> findAllUser(String query, Integer pagenum, Integer pagesize) {
        Page<User> page = new Page<>(pagenum, pagesize);
        return page.setRecords( this.baseMapper.findAllUserByPage(page,query));
    }

    @Override
    public Boolean addOneUser(User user) {
        // 添加默认角色
        user.setRid("30");
        boolean result = save(user);
        return result;
    }

    @Override
    public User findUserById(Integer id) {
        User user = getById(id);
        return user;
    }

    @Override
    public Boolean updateUserById(User user) {
        return updateById(user);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return removeById(id);
    }

    @Override
    public Boolean updateUserRoleId(Integer id, Integer rid) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("role_id",rid).eq("id",id);
        return update(updateWrapper);
    }
}
