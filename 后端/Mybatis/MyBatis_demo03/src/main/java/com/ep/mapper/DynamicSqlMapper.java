package com.ep.mapper;

import com.ep.pojo.Dept;
import com.ep.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {

    /*
    * 动态sql获取员工信息
    * */
    List<Emp> getEmpByDynamicSql(Emp emp);

    /*
    * 批量删除员工，通过foreach标签
    * */
    int deleteMoreEmp(@Param("eids") Integer[] eids);

    /*
    * 批量添加员工
    * */
    int insertMoreEmp(@Param("emps") List<Emp> emps);
}
