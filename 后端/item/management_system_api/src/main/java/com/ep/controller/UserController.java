package com.ep.controller;


import com.ep.domain.ResultInfo;
import com.ep.domain.User;
import com.ep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 用户控制层
 */
@Slf4j
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo Login(@RequestBody User user){
        User u = userService.Login(user.getUsername(), user.getPassword());
        ResultInfo info = new ResultInfo();
        if ( u== null) {
            info.setStatus(422);
            info.setMessage("用户名或者密码或者错误");
        }else {
            info.setStatus(200);
            info.setMessage("请求成功");
        }
        return info;
    }
}
