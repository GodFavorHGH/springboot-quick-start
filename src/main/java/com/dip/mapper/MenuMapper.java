package com.dip.mapper;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Menu;

public interface MenuMapper {

    List<Menu> getMenuTreeList(String parentId, String menuLevel);

}
