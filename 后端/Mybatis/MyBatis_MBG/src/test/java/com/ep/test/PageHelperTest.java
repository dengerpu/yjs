package com.ep.test;

import com.ep.mapper.EmpMapper;
import com.ep.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    /*
    * 分页插件的使用
    * */
    @Test
    public void testPage() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession = new
                SqlSessionFactoryBuilder().build(is).openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //Page<Object> objects = PageHelper.startPage(1, 5);
        PageHelper.startPage(1,5);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        //System.out.println(objects);
        emps.forEach(emp -> System.out.println(emp));
        System.out.println(empPageInfo);
    }
}
