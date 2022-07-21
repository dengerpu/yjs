package com.ep.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ep.vo.PageBean;
import com.ep.vo.ResultInfo;
import com.ep.pojo.User;
import com.ep.service.UserService;
import com.ep.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        ResultInfo info = new ResultInfo();
        if (u == null) {
            info.setStatus(422);
            info.setMessage("用户名或者密码错误");
        }else {
            info.setStatus(200);
            info.setMessage("登陆成功");
            info.setData(u);
        }
        return info;
    }

    @GetMapping("/users")
    public ResultInfo findAllUser(String query, Integer pagenum, Integer pagesize){
        Page<User> allUser = userService.findAllUser(query, pagenum, pagesize);
        ResultInfo info = new ResultInfo();
        if (info == null){
            info.setStatus(400);
            info.setMessage("请求失败");
        }else {
            info.setStatus(200);
            info.setMessage("请求成功");
            info.setData(allUser);
        }
        return info;
    }

    @PostMapping("/users")
    public ResultInfo addOneUser(@RequestBody User user){
        Boolean aBoolean = userService.addOneUser(user);
        ResultInfo info = new ResultInfo();
        if (!aBoolean){
            info.setStatus(422);
            info.setMessage("添加失败");
        }else {
            info.setStatus(201);
            info.setMessage("添加成功");
        }
        return info;
    }

    @GetMapping( "/users/{id}")
    public ResultInfo findOneUser(@PathVariable Integer id){
        User user = userService.findUserById(id);
        ResultInfo info = new ResultInfo();
        if (user== null){
            info.setStatus(422);
            info.setMessage("请求失败");
        }else {
            info.setStatus(201);
            info.setMessage("请求成功");
            info.setData(user);
        }
        return info;
    }

    @PutMapping( "/users/{id}")
    public ResultInfo addOneUser(@PathVariable Integer id, @RequestBody User user){
        user.setId(id);
        Boolean aBoolean = userService.updateUserById(user);
        ResultInfo info = new ResultInfo();
        if (!aBoolean){
            info.setStatus(422);
            info.setMessage("修改失败");
        }else {
            info.setStatus(201);
            info.setMessage("修改成功");
            info.setData(user);
        }
        return info;
    }

    @DeleteMapping( "/users/{id}")
    public ResultInfo deleteOneUser(@PathVariable Integer id){

        Boolean aBoolean = userService.deleteUserById(id);
        ResultInfo info = new ResultInfo();
        if (!aBoolean){
            info.setStatus(422);
            info.setMessage("删除失败");
        }else {
            info.setStatus(204);
            info.setMessage("删除成功");
        }
        return info;
    }

    @PutMapping("`users/{id}/role`")
    public ResultInfo updateUserRoleID(@PathVariable Integer id, Integer rio){
        ResultInfo info = new ResultInfo();
        return info;
    }


}
