package com.ep.mapper;

import com.ep.pojo.User;

import java.util.List;

public interface UserMapper {

    /*
    * MyBatis中可以面向接口操作数据，要保证两个一致：
       mapper接口的全类名和映射文件的命名空间（namespace）保持一致
       mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致
    * */


    /*
    * 添加用户
    * */
    int insertUser();

    /*
    * 修改用户
    * */
    int updateUser();

    /*
    * 删除用户
    * */
    int deleteUser();

    /*
    * 查询所有用户
    * */
    List<User> queryAllUser();

}
