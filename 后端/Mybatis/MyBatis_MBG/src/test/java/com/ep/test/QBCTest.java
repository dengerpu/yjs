package com.ep.test;

import com.ep.mapper.EmpMapper;
import com.ep.pojo.Emp;
import com.ep.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QBCTest {

    @Test
    public void testMBG() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession = new
                SqlSessionFactoryBuilder().build(is).openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 查询所有
//        List<Emp> emps = mapper.selectByExample(null);
//        System.out.println(emps);

        //条件查找
        //创建条件对象，通过andXXX方法为SQL添加查询添加，每个条件之间是and关系
//        EmpExample empExample = new EmpExample();
//        empExample.createCriteria().andDidEqualTo(2).andAgeGreaterThan(20);
//        //将之前添加的条件通过or拼接其他条件
//        empExample.or().andEmailEqualTo("123@qq.com");
//        List<Emp> emps = mapper.selectByExample(empExample);
//        System.out.println(emps);

        // 添加
       // mapper.insert(new Emp(null,"insert",18,"男","123@qq.com",2));
        // 条件添加
        //mapper.insertSelective(new Emp(null,"insert",18,null,"123@qq.com",2));

        // 修改
        EmpExample empExample = new EmpExample();
       // mapper.updateByPrimaryKey(new Emp(12,"insert",18,"男","123@qq.com",2));
        mapper.updateByPrimaryKey(new Emp(12,"insert2",null,null,"123456789@qq.com",2));
    }
}
