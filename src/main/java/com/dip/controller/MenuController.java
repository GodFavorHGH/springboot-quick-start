package com.dip.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.domain.concrete.Menu;

@RestController
@RequestMapping("/menu")
@SuppressWarnings({"rawtypes", "unchecked"})
public class MenuController {

	@RequestMapping("/menus")
	public Result getMenuList() {
		List<Menu> menus = null;
		Result res = Result.success();
		res.setData(menus);
		return res;
	}
	
}
