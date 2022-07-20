package com.ep.mybatis_plus;

import com.ep.mybatis_plus.pojo.User;
import com.ep.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectCount() {
        //  SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总数为:" + count);
    }

    // 批量添加
    @Test
    public void testsaveMoreUser() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("dep" + i);
            user.setAge(i);
            user.setEmail("123@qq.com");
            list.add(user);
        }
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


}
