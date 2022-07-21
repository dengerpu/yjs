package com.ep.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ep.mapper.MenuMapper;
import com.ep.pojo.Menus;
import com.ep.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menus> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menus> findAllMenus() {
        List<Menus> allMenu = menuMapper.findAllMenu();
        return allMenu;
    }
}
