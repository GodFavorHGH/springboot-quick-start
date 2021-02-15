package com.dip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dip.domain.concrete.Menu;
import com.dip.mapper.MenuMapper;
import com.dip.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Cacheable(key = "#parentId+'-'+#menuLevel", value = "menus")
    public List<Menu> getMenuTreeList(String parentId, String menuLevel) {
        // TODO Auto-generated method stub
        return menuMapper.getMenuTreeList(parentId, menuLevel);
    }

}
