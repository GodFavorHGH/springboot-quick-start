package com.dip.service;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Menu;

public interface SystemCachedDataService {

	List<Map> loadTranscodes();
	
	List<Menu> loadMenus(String parentId, String menuLevel);
	
	List<Map> loadProducts();
	
}
