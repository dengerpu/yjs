package com.ep.test;

import com.ep.mapper.SqlMapper;
import com.ep.pojo.User;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SqlTest {

    @Test
    public void testMohu(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> userList = mapper.testMohu("a");
        System.out.println(userList);
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int i = mapper.deleteMore("5,6,7");
        System.out.println(i);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> user = mapper.getAllUser("user");
        System.out.println(user);
    }
    @Test
    public void  insertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User(0,"lisi","1233456",15,"女","123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
