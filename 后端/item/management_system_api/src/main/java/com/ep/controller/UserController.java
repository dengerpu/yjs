package com.ep.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ep.vo.ResultInfo;
import com.ep.pojo.User;
import com.ep.service.UserService;
import com.ep.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/***
 * 用户控制层
 */
@Slf4j
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultInfo Login(@RequestBody User user){
        UserInfo u = userService.Login(user.getUsername(), user.getPassword());
        if (u == null) {
            return ResultInfo.fail(422,"用户名或者密码错误");
        }else {
            return ResultInfo.success(u);
        }
    }

    @GetMapping("/users")
    public ResultInfo findAllUser(String query, Integer pagenum, Integer pagesize){
        Page<User> allUser = userService.findAllUser(query, pagenum, pagesize);
        if (allUser == null){
            return ResultInfo.fail(400,"请求失败");
        }else {
           return ResultInfo.success(allUser);
        }
    }

    @PostMapping("/users")
    public ResultInfo addOneUser(@RequestBody User user){
        Boolean aBoolean = userService.addOneUser(user);
        if (!aBoolean){
           return ResultInfo.fail(422,"添加失败");
        }else {
            return ResultInfo.success(201,"添加成功",null);
        }
    }

    @GetMapping( "/users/{id}")
    public ResultInfo findOneUser(@PathVariable Integer id){
        User user = userService.findUserById(id);
        if (user== null){
            return ResultInfo.fail(422,"请求失败");
        }else {
            return ResultInfo.success(201,"请求成功", user);
        }

    }

    @PutMapping( "/users/{id}")
    public ResultInfo addOneUser(@PathVariable Integer id, @RequestBody User user){
        user.setId(id);
        Boolean aBoolean = userService.updateUserById(user);
        if (!aBoolean){
            return ResultInfo.fail(422,"修改失败");
        }else {
            return ResultInfo.success(201,"修改成功", user);
        }
    }

    @DeleteMapping( "/users/{id}")
    public ResultInfo deleteOneUser(@PathVariable Integer id){
        Boolean aBoolean = userService.deleteUserById(id);
        if (!aBoolean){
            return ResultInfo.fail(422,"删除失败");
        }else {
            return ResultInfo.success(204,"删除成功", null);
        }
    }

    @PutMapping("/users/{id}/role")
    public ResultInfo updateUserRoleID(@PathVariable Integer id, @RequestBody Map<String, Integer> data){
        Boolean aBoolean = userService.updateUserRoleId(id, data.get("rid"));
        if (!aBoolean){
            return ResultInfo.fail(422,"修改失败");
        }else {
            return ResultInfo.success(201,"修改成功", null);
        }
    }

    @PutMapping("/users/{id}/state/{state}")
    public ResultInfo updateUserState(@PathVariable Integer id, @PathVariable Boolean state){
        Boolean aBoolean = userService.updateUserState(id, state);
        if (!aBoolean){
            return ResultInfo.fail(422,"修改失败");
        }else {
            return ResultInfo.success(201,"修改成功", null);
        }
    }


}
