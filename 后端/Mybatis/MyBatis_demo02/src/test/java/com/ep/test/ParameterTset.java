package com.ep.test;

import com.ep.mapper.ParameterMapper;
import com.ep.mapper.UserMapper;
import com.ep.pojo.User;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class ParameterTset {
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.queryAllUser();
        System.out.println(users);
    }
    @Test
    public void testGetUserByname(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.getUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    public void testLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLogin("admin", "123");
        System.out.println(user);
    }

    @Test
    public void testLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("username","admin");
        hashMap.put("password","123");
        User user = parameterMapper.checkLoginByMap(hashMap);
        System.out.println(user);
    }
    @Test
    public void testLoginByUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.ckeckLoginByUser(new User(0,"admin", "123", 0, null, null));
        System.out.println(user);
    }

    @Test
    public void testLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLoginByParam("admin", "123");
        System.out.println(user);
    }


}
