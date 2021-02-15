package com.dip.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.annotation.WriteJournal;
import com.dip.common.Result;
import com.dip.constants.IdType;
import com.dip.constants.ResultCode;
import com.dip.domain.concrete.EUser;
import com.dip.domain.concrete.Menu;
import com.dip.exception.BizException;
import com.dip.service.EUserService;
import com.dip.service.MenuService;
import com.dip.system.impl.ApplicationContext;
import com.dip.utils.DataConvertUtil;
import com.dip.utils.RedisUtils;

@RestController
@RequestMapping("/user")
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
@EnableCaching
public class EUserController {

	@Autowired
	private ApplicationContext applicationContext;
	
    @Autowired
    private EUserService euserService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/register")
    @WriteJournal
    public Result register(@RequestBody String params) {
        Map insertData = DataConvertUtil.convertJsonToMap(params);
        EUser user = new EUser();
        user.setName((String) insertData.get("name"));
        user.setIdNo((String) insertData.get("idNo"));
        user.setIdType(IdType.valueOf((String) insertData.get("idType")));
        user.setPhone((String) insertData.get("phoneNo"));
        user.setPassword((String) insertData.get("password"));
        int count = euserService.registerEUser(user);
        Result res = count == 1 ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "新增用户失败!");
        return res;
    }

    @WriteJournal
    @RequestMapping("/login")
    public Result doLogin(@RequestBody String params) {
    	Object s = redisTemplate.opsForValue().get("products");
    	System.out.println(s);
        Map loginData = DataConvertUtil.convertJsonToMap(params);
        EUser e = applicationContext.getUser();
        EUser user = euserService.getEUserByLoginInfo((String) loginData.get("phone"), (String) loginData.get("password"));
        if (user == null) {
			throw new BizException("999", "用户不存在!");
//            return Result.failure(ResultCode.FAILURE.getCode(), "用户不存在!");
        }
        applicationContext.setEuser(user);
        EUser e2 = applicationContext.getUser();
        //登陆成功，查询菜单列表给前端
        List<Menu> menus = menuService.getMenuTreeList("root", "1");
        user.setMenus(menus);
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

    @WriteJournal
    @RequestMapping("/update")
    public Result update(@RequestBody String params) {
        Map updateMap = DataConvertUtil.convertJsonToMap(params);
        List<EUser> users = euserService.listAllEUser(updateMap);
        if (users == null || users.size() == 0) {
            return Result.failure(ResultCode.FAILURE.getCode(), "用户信息不存在!");
        }
        if (users.size() != 1) {
            return Result.failure(ResultCode.FAILURE.getCode(), "存在多个相同信息的用户!");
        }
        updateMap.put("id", users.get(0).getId());
        int count = euserService.updateEUser(updateMap);
        return count == 1 ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "用户信息更新失败!");
    }

    @RequestMapping("/update2")
    public Result update2(EUser user) {
        int count = euserService.updateByEUser(user);
        return count == 1 ? Result.success() : Result.failure(ResultCode.FAILURE.getCode(), "用户信息更新失败!");
    }
    
    @RequestMapping("/test")
    public Result test() {
    	return Result.success();
    }
}
