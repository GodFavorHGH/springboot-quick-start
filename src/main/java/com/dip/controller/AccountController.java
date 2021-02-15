package com.dip.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource(value = {"classpath:extras-config.properties"}, encoding = "utf-8")
public class AccountController {

    @Value(value = "${extrasConfig.defaultPageSize}")
    private int defaultPageSize;
    @Value(value = "${extrasConfig.defaultStartSize}")
    private int defaultStartSize;
    @Autowired
    private EUserService euserService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/add")
    public Result add(@RequestBody String params) {
        Map insertMap = DataConvertUtil.convertJsonToMap(params);
        List<EUser> users = euserService.listAllEUser(insertMap);
        if (users == null || users.size() == 0) {
            return Result.failure(ResultCode.FAILURE.getCode(), "用户信息不存在!");
        }
        if (users.size() != 1) {
            return Result.failure(ResultCode.FAILURE.getCode(), "存在多个相同信息的用户!");
        }
        EUser user = users.get(0);
        Account account = new Account();
        account.setAcNo((String) insertMap.get("acNo"));
        account.setAcName(user.getName());
        account.setUserId(user.getId());
        account.setAcType(AcType.valueOf((String) insertMap.get("acType")));
        account.setAcState(AcState.N);
        int count = accountService.addEUserAccount(account);
        return count == 1 ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "新增用户账户失败！");
    }

    @RequestMapping("/getAccount")
    public Result getAccount(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        Account account = accountService.getAccountInfoWithEUser((Integer) queryMap.get("id"));
        Result<Account> res = Result.success();
        res.setData(account);
        return res;
    }

    @RequestMapping("/getAccounts")
    public Result getAccounts(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        List<Account> accounts = accountService.getAccountListByType((List) queryMap.get("acTypes"));
        Result<List<Account>> res = Result.success();
        res.setData(accounts);
        System.out.println("===");
        return res;
    }

    @RequestMapping("/addBatch")
    public Result addBatch(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        List<Map> list = (List) queryMap.get("accounts");
        Account account = null;
        EUser euser = null;
        List<Account> accounts = new ArrayList(list.size());
        for (Map ac : list) {
            account = new Account();
            euser = euserService.getEUserInfoWithAccount((Integer) ac.get("userId"));
            account.setUserId((Integer) ac.get("userId"));
            account.setAcNo((String) ac.get("acNo"));
            account.setAcName(euser.getName());
            account.setAcType(AcType.valueOf((String) ac.get("acType")));
            account.setAcState(AcState.N);
            accounts.add(account);
        }
        int count = accountService.addBatch(accounts);
        return count == accounts.size() ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "批量新增用户账户失败！");
    }

    @RequestMapping("/getAcList")
    public Result getAcList(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        List<Account> accounts = accountService.getAcListByUserId((Integer) queryMap.get("userId"));
        Result res = Result.success();
        res.setData(accounts);
        return res;
    }

    @RequestMapping("/paginationQuery")
    public Result paginationQuery(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        int startIndex = (Integer) queryMap.get("startIndex") != null ? (Integer) queryMap.get("startIndex") : defaultStartSize;
        int pageSize = (Integer) queryMap.get("pageSize") != null ? (Integer) queryMap.get("pageSize") : defaultPageSize;
        queryMap.put("startIndex", startIndex);
        queryMap.put("pageSize", pageSize);
        List<Account> accounts = accountService.paginationQuery(queryMap);
        Result res = Result.success();
        res.setData(accounts);
        return res;
    }

    @RequestMapping("/paginateQuery")
    public Result paginateQuery(int startIndex, int pageSize) {
        int startIndex1 = startIndex != 0 ? startIndex : defaultStartSize;
        int pageSize1 = pageSize != 0 ? pageSize : defaultPageSize;
        Map queryMap = new HashMap();
        queryMap.put("startIndex", startIndex1);
        queryMap.put("pageSize", pageSize1);
        List<Account> accounts = accountService.paginationQuery(queryMap);
        Result res = Result.success();
        res.setData(accounts);
        return res;
    }

    @RequestMapping("/updateBatch")
    public Result updateBatch(@RequestBody String params) {
        Map queryMap = DataConvertUtil.convertJsonToMap(params);
        List<Map> list = (List) queryMap.get("accounts");
        Account account = null;
        EUser euser = null;
        List<Account> accounts = new ArrayList(list.size());
        for (Map ac : list) {
            account = new Account();
            euser = euserService.getEUserInfoWithAccount((Integer) ac.get("userId"));
            account.setUserId((Integer) ac.get("userId"));
            account.setAcNo((String) ac.get("acNo"));
            account.setAcName(euser.getName());
            account.setAcType(AcType.valueOf((String) ac.get("acType")));
            account.setAcState(AcState.N);
            accounts.add(account);
        }
        int count = accountService.updateBatch(accounts);
        return count == accounts.size() ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "批量更新用户账户失败！");
    }
}
