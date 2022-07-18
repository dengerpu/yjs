package com.ep.test;

import com.ep.mapper.DeptMapper;
import com.ep.pojo.Dept;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptTest {
    @Test
    public void testGetAllDepts() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
//        List<Dept> allDept = mapper.findAllDept(2);
//        System.out.println(allDept);
        Dept deptByStepOne = mapper.findDeptByStepOne(2);
        System.out.println(deptByStepOne.getDeptName());
    }
}
