package com.dip.service;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Menu;

public interface MenuService {

    List<Menu> getMenuTreeList(String parentId, String menuLevel);

}
