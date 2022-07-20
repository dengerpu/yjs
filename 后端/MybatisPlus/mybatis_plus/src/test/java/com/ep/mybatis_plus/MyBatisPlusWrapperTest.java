package com.ep.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ep.mybatis_plus.mapper.UserMapper;
import com.ep.mybatis_plus.pojo.User;
import com.ep.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        ////查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        // ==>  Preparing: SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        //==> Parameters: %a%(String), 20(Integer), 30(Integer)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02() {
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        // ==>  Preparing: SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        // UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    @Test
    void test04() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@qq.com");
        // ==>  Preparing: UPDATE t_user SET age=?, email=? WHERE is_deleted=0 AND (age >= ? AND user_name LIKE ? OR email IS NULL)
        //==> Parameters: 18(Integer), user@qq.com(String), 20(Integer), %a%(String)
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    public void test05() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //lambda表达式内的逻辑优先运算
        queryWrapper.like("user_name", "a")
                .and(i -> i.ge("age", 20).isNull("email"));
        User user = new User();
        user.setAge(18);
        user.setEmail("update@qq.com");
        // ==>  Preparing: UPDATE t_user SET age=?, email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? AND email IS NULL))
        //==> Parameters: 18(Integer), update@qq.com(String), %a%(String), 20(Integer)
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    public void test06() {
        //查询用户信息的username和age字段
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age");
        //SELECT user_name,age FROM t_user WHERE is_deleted=0
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test07() {
        //查询id小于等于3的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid <= 3");
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid <= 3))
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test08() {
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //组装set子句以及修改条件
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        //lambda表达式内的逻辑优先运算
        userUpdateWrapper.set("user_name", "小黑")
                .set("age", 30)
                .like("user_name", "a")
                .and(i -> i.ge("age", 20).isNull("email"));
        // ==>  Preparing: UPDATE t_user SET user_name=?,age=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? AND email IS NULL))
        //==> Parameters: 小黑(String), 30(Integer), %a%(String), 20(Integer)
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println(update);

    }

    @Test
    public void test09() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = null;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test10() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = null;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test11() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = null;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void test12() {
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //组装set子句以及修改条件
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(User::getName, "小黑")
                .set(User::getAge, 30)
                .like(User::getName, "a")
                .and(i -> i.ge(User::getAge, 20).isNull(User::getEmail));
        // ==>  Preparing: UPDATE t_user SET user_name=?,age=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age >= ? AND email IS NULL))
        //==> Parameters: 小黑(String), 30(Integer), %a%(String), 20(Integer)
        int update = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println(update);

    }


}
