package com.ep.test;

import com.ep.mapper.EmpMapper;
import com.ep.pojo.Emp;
import com.ep.utils.SqlSessionUtils;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpTest {
    @Test
    public void testFindAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.findAllEmp();
        allEmp.forEach(emp -> {System.out.println(emp);});
    }
    @Test
    public void testFindOneEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empOne = mapper.findEmpOne(1);
        System.out.println(empOne);
    }

    @Test
    public void testFindOneEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empOneByStepOne = mapper.findEmpOneByStepOne("1");
        System.out.println(empOneByStepOne.getEmpName());
    }

}
