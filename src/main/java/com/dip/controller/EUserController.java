package com.dip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.constants.IdType;
import com.dip.constants.ResultCode;
import com.dip.domain.concrete.EUser;
import com.dip.service.EUserService;
import com.dip.service.RuleService;
import com.dip.utils.DataConvertUtil;

@RestController
@RequestMapping("/user")
@SuppressWarnings({"rawtypes","unchecked"})
public class EUserController {

	@Autowired
	private EUserService euserService;
	
	@Autowired
	private RuleService ruleService;
	
	@RequestMapping("/register")
	public Result register(@RequestBody String params) {
		Map insertData = DataConvertUtil.convertJsonToMap(params);
		EUser user = new EUser();
		user.setName((String)insertData.get("name"));
		user.setIdNo((String)insertData.get("idNo"));
		user.setIdType(IdType.valueOf((String)insertData.get("idType")));
		user.setPhone((String)insertData.get("phoneNo"));
		user.setPassword((String)insertData.get("password"));
		int count = euserService.registerEUser(user);
		Result res = count==1?Result.success():Result.failure(ResultCode.FAILURE.getCode(), "新增用户失败!");
		return res;
	}
	
	@RequestMapping("/login")
	public Result doLogin(@RequestBody String params) {
		Map loginData = DataConvertUtil.convertJsonToMap(params);
		EUser user = euserService.getEUserByLoginInfo(loginData);
		if (user==null) {
			return Result.failure(ResultCode.FAILURE.getCode(), "用户不存在!");
		}
		Result<EUser> res = Result.success();
		res.setData(user);
		return res;
	}
	
	@RequestMapping("/listAll")
	public Result listAll(@RequestBody String params) {
		Map queryData = DataConvertUtil.convertJsonToMap(params);
		List<EUser> users = euserService.listAllEUser(queryData);
		Result res = Result.success();
		res.setData(users);
		return res;
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody String params) {
		Map updateMap = DataConvertUtil.convertJsonToMap(params);
		List<EUser> users = euserService.listAllEUser(updateMap);
		if (users==null||users.size()==0) {
			return Result.failure(ResultCode.FAILURE.getCode(), "用户信息不存在!");
		}
		if (users.size()!=1) {
			return Result.failure(ResultCode.FAILURE.getCode(), "存在多个相同信息的用户!");
		}
		updateMap.put("id", users.get(0).getId());
		int count = euserService.updateEUser(updateMap);
		return count==1?Result.success():Result.failure(ResultCode.FAILURE.getCode(), "用户信息更新失败!");
	}
}
