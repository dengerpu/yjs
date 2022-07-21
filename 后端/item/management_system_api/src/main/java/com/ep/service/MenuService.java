package com.ep.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ep.pojo.Menus;

import java.util.List;

public interface MenuService extends IService<Menus> {

    /***
     * 获取菜单列表
     * @return
     */
    List<Menus> findAllMenus();
}
