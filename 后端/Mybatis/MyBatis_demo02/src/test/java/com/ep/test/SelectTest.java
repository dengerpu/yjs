package com.ep.test;

import com.ep.mapper.SelectMapper;
import com.ep.pojo.User;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User userById = selectMapper.getUserById(1);
        System.out.println(userById);
    }
    @Test
    public void testSelectByUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = selectMapper.getUserList();
        System.out.println(userList);
    }
    @Test
    public void testSelectByType(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testSelectByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = selectMapper.getUserToMap(1);
        System.out.println(userToMap);
    }
    @Test
    public void testSelectByListMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String, Object>> allUserToMap = selectMapper.getAllUserToMap();
        Map<String, Object> allUserToMap = selectMapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
}
