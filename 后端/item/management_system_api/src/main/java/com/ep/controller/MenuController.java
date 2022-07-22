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
        if (allMenus == null) {
            return ResultInfo.fail(422,"菜单列表为空");
        }else {
            return ResultInfo.success(allMenus);
        }
    }
}
