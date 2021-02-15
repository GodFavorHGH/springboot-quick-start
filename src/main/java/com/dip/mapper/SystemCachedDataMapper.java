package com.dip.mapper;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Menu;

public interface SystemCachedDataMapper {

	
	List<Map> loadTranscodes();
	
	List<Menu> loadMenus(String parentId, String menuLevel);
	
	List<Map> loadProducts();
	
}
