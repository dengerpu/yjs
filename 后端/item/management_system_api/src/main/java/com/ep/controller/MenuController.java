package com.ep.controller;

import com.ep.pojo.Menus;
import com.ep.service.MenuService;
import com.ep.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menus")
    public ResultInfo findMenu(){
        List<Menus> allMenus = menuService.findAllMenus();
        ResultInfo info = new ResultInfo();
        if (allMenus == null) {
            info.setStatus(422);
            info.setMessage("菜单列表为空");
        }else {
            info.setStatus(200);
            info.setMessage("获取成功");
            info.setData(allMenus);
        }
        return info;
    }
}
