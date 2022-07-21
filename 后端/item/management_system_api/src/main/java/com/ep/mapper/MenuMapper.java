package com.ep.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ep.pojo.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menus> {

    List<Menus> findAllMenu();

    List<Menus> findSecondMenu(@Param("pid") Integer pid);
}
