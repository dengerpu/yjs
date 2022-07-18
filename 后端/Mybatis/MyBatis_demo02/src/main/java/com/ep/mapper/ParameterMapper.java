package com.ep.mapper;

import com.ep.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ParameterMapper {

    /*
    根据用户名查询用户信息
    */
    User getUserByUsername(String username);

    /*
    * 登陆
    * */
    User checkLogin(String username, String password);

    /*
    * 采用map传参
    * */
    User checkLoginByMap(Map<String, Object> map);

    /*
    * 采用实体传参
    * */
    User ckeckLoginByUser(User user);

    /*
    * 采用param传参
    * */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
