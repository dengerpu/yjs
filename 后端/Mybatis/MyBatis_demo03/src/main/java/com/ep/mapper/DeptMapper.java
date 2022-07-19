package com.ep.mapper;

import com.ep.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {
    /*
     * 分布查询获取员工的信息以及部门信息
     * 2.根据员工信息的返回值获取部门信息
     * */
    Dept findDeptOne(@Param("id") int id);

    /*
    * 根据部门id查询部门的员工信息
    * */
    List<Dept> findAllDept(@Param("id") int id);

    /*
    * 一对多分布查询，部门以及部门成员
    * 1.查询部门信息
    * */
    Dept findDeptByStepOne(@Param("id") int id);
}
