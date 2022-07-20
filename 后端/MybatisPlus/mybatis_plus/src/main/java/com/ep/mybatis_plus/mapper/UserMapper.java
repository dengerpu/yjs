package com.ep.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ep.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    /*
     * 自定义功能，根据id查找
     * */
    User selectUserById(@Param("id") Integer id);


    /***
     * 自定义功能根据年龄分页
     * @param page mybatis-plus提供的，必须放在第一位
     * @param age
     * @return
     */
    Page<User> selectUserByAgeVo(Page<User> page, Integer age);

}
