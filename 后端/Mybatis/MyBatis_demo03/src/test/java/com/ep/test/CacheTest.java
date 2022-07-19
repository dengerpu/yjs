package com.ep.test;

import com.ep.mapper.EmpMapper;
import com.ep.pojo.Emp;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    @Test
    public void testFindOneEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empOne = mapper.findEmpOne(1);
        System.out.println(empOne);
        sqlSession.close();
//        Emp empOne2 = mapper.findEmpOne(1);
//        System.out.println(empOne2);
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        Emp empOne1 = mapper1.findEmpOne(1);
        System.out.println(empOne1);
        sqlSession1.close();
    }

    @Test
    public void testCachetwo(){
        try {
            InputStream  is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            Emp empOne = mapper.findEmpOne(1);
            System.out.println(empOne);
            sqlSession.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);
            Emp empOne2 = mapper2.findEmpOne(1);
            System.out.println(empOne2);
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
