package com.ep.mybatis_plus;

import com.ep.mybatis_plus.mapper.UserMapper;
import com.ep.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootTest
public class MybatisPlustest {

    @Autowired
    private UserMapper userMapper;

    /*
     * 测试查询功能
     * */
    @Test
    public void testSelectList() {

        //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /*
     * 测试插入功能
     * */
    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "zhangsan@atguigu.com", null, null);
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        userMapper.insert(user);
        System.out.println("id自动获取:" + user.getId());
    }

    /*
     * 通过id删除用户信息
     * */
    @Test
    public void testDeleteById() {
        // DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(8);
        System.out.println(result);
    }

    /*
     * 通过id批量删除记录
     * */
    @Test
    public void testDeleteByIDS() {
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println(result);

    }

    /*
     * 通过map条件删除记录
     * */
    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        // DELETE FROM user WHERE name = ? AND age = ?
        int result = userMapper.deleteByMap(map);
        System.out.println(result);

    }

    /*
     * 修改用户信息
     * */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4L);
        user.setAge(20);
        user.setName("lisi");
        // UPDATE user SET name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println(result);

    }

    /*
     * 根据id查询用户信息
     * */
    @Test
    public void testSelectById() {
        // SELECT id,name,age,email FROM user WHERE id=?
//        User user = userMapper.selectById(1L);
//        System.out.println(user);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }

    /*
     * 根据多个id查询多个用户信息
     * */
    @Test
    public void testSelectByIds() {
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println(users);
    }

    /*
     * 通过map条件查询用户信息
     * */
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }
}
