package com.ep.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ep.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    /*
    * 自定义功能，根据id查找
    * */
    User selectUserById(@Param("id")Integer id);
}
