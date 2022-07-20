package com.ep.mybatis_plus;

import com.ep.mybatis_plus.enums.SexEnum;
import com.ep.mybatis_plus.mapper.UserMapper;
import com.ep.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum() {
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
//设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
    }

}
