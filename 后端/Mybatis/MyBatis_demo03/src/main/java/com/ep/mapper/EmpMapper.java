package com.ep.mapper;

import com.ep.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {


    /*
    * 查找所有员工信息
    * */
    List<Emp> findAllEmp();

    /*
    * 通过级联属性获取员工以及部门信息
    * */
    Emp findEmpOne(@Param("id") int id);

    /*
    * 分布查询获取员工的信息以及部门信息
    * 1.获取员工信息
    * */
    Emp findEmpOneByStepOne(@Param("id") String id);

    /*
     * 一对多分布查询，部门以及部门成员
     * 2 查询部门成员信息
     * */
    List<Emp>  findDeptByStepTwo(@Param("did") int did);

}
