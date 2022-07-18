package com.ep.mapper;

import com.ep.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {
    /**
     * 测试模糊查询
     * @param query
     * @return
     */
    List<User> testMohu(@Param("query") String query);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 动态设置表名，查询所有的用户信息
     * @param tableName
     * @return
     */
    List<User> getAllUser(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
    数user对象的某个属性中
     */
    int insertUser(User user);
}
