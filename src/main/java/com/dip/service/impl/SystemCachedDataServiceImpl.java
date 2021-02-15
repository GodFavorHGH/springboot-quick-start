package com.dip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dip.domain.concrete.Menu;
import com.dip.mapper.SystemCachedDataMapper;
import com.dip.service.SystemCachedDataService;

@Service
public class SystemCachedDataServiceImpl implements SystemCachedDataService {

	@Autowired
	private SystemCachedDataMapper systemCachedDataMapper;
	
	@Override
	public List<Map> loadTranscodes() {
		// TODO Auto-generated method stub
		return systemCachedDataMapper.loadProducts();
	}

	@Override
	public List<Menu> loadMenus(String parentId, String menuLevel) {
		// TODO Auto-generated method stub
		return systemCachedDataMapper.loadMenus(parentId, menuLevel);
	}

	@Override
	public List<Map> loadProducts() {
		// TODO Auto-generated method stub
		return systemCachedDataMapper.loadTranscodes();
	}

}
