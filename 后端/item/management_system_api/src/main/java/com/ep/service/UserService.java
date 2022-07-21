package com.ep.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ep.pojo.User;
import com.ep.vo.PageBean;
import com.ep.vo.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    /**
     * 登陆
     * @param username 账号
     * @param password 密码
     * @return
     */
    UserInfo Login(String username, String password);

    /**
     * 分页查询用户信息
     * @param query 查询信息
     * @param pagenum   当前页
     * @param pagesize  每页大小
     * @return
     */
    Page<User> findAllUser(String query, Integer pagenum, Integer pagesize);

    /***
     * 添加一个用户
     * @param user
     * @return
     */
    Boolean addOneUser(User user);

    /***
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /***
     * 根据id修改用户
     * @param user
     * @return
     */
    Boolean updateUserById(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Boolean deleteUserById(Integer id);

    /***
     * 根据id修改用户角色id
     * @param id
     * @param rid
     * @return
     */
    Boolean updateUserRoleId(Integer id, Integer rid);
}
