package com.dip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.constants.AcState;
import com.dip.constants.AcType;
import com.dip.constants.ResultCode;
import com.dip.domain.concrete.Account;
import com.dip.domain.concrete.EUser;
import com.dip.service.AccountService;
import com.dip.service.EUserService;
import com.dip.utils.DataConvertUtil;
@RestController
@RequestMapping("/account")
@SuppressWarnings({"rawtypes", "unchecked"})
public class AccountController {

	@Autowired
	private EUserService euserService;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/add")
	public Result add(@RequestBody String params) {
		Map insertMap = DataConvertUtil.convertJsonToMap(params);
		List<EUser> users = euserService.listAllEUser(insertMap);
		if (users==null||users.size()==0) {
			return Result.failure(ResultCode.FAILURE.getCode(), "用户信息不存在!");
		}
		if (users.size()!=1) {
			return Result.failure(ResultCode.FAILURE.getCode(), "存在多个相同信息的用户!");
		}
		EUser user = users.get(0);
		Account account = new Account();
		account.setAcNo((String)insertMap.get("acNo"));
		account.setAcName(user.getName());
		account.setUserId(user.getId());
		account.setAcType(AcType.valueOf((String)insertMap.get("acType")));
		account.setAcState(AcState.N);
		int count = accountService.addEUserAccount(account);
		return count==1?Result.success():Result.failure(ResultCode.FAILURE.getCode(), "新增用户账户失败！");
	}
	
	@RequestMapping("/getAccount")
	public Result getAccount(@RequestBody String params) {
		Map queryMap = DataConvertUtil.convertJsonToMap(params);
		Account account = accountService.getAccountInfoWithEUser((Integer)queryMap.get("id"));
		Result<Account> res = Result.success();
		res.setData(account);
		return res;
	}
	
	@RequestMapping("/getAccounts")
	public Result getAccounts(@RequestBody String params) {
		Map queryMap = DataConvertUtil.convertJsonToMap(params);
		List<Account> accounts = accountService.getAccountListByType((List)queryMap.get("acTypes"));
		Result<List<Account>> res = Result.success();
		res.setData(accounts);
		return res;
	}
}
