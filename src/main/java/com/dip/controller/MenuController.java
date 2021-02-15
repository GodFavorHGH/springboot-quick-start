package com.dip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.domain.concrete.Menu;
import com.dip.service.MenuService;

@RestController
@RequestMapping("/menu")
@SuppressWarnings({"rawtypes", "unchecked"})
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menus")
    public Result getMenuList() {
        List<Menu> menus = menuService.getMenuTreeList("root", "1");
        Result res = Result.success();
        res.setData(menus);
        return res;
    }

}
