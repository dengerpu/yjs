package com.ep.test;

import com.ep.mapper.DynamicSqlMapper;
import com.ep.pojo.Emp;
import com.ep.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSqlTest {
    @Test
    public void testGetDemp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp = new Emp(0, "", "", "123@qq.com", "", null);
        List<Emp> empByDynamicSql = mapper.getEmpByDynamicSql(emp);
        System.out.println(empByDynamicSql);
    }

    @Test
    public void testDeleteDemp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreEmp(new Integer[]{6, 7, 8, 9,10,11});
        System.out.println(i);
    }

    @Test
    public void testInsertDemp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(0,"a","18","123456@qq.com","男",null);
        Emp emp2 = new Emp(0,"b","18","123456@qq.com","男",null);
        Emp emp3 = new Emp(0,"c","18","123456@qq.com","男",null);
        List<Emp> emps = Arrays.asList(emp1,emp2,emp3);
        int i = mapper.insertMoreEmp(emps);
        System.out.println(i);
    }
}
