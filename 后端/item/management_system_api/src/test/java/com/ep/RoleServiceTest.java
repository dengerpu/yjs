package com.ep;

import com.ep.pojo.Role;
import com.ep.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindAllRolesAndPermission() {
        List<Role> allroles = roleService.findAllRolesAndPermission();
        allroles.forEach(System.out::println);
    }
}
