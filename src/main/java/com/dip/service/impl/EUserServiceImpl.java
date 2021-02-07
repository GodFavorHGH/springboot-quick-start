package com.dip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dip.domain.concrete.EUser;
import com.dip.mapper.EUserMapper;
import com.dip.service.EUserService;

@Service
public class EUserServiceImpl implements EUserService {

	@Autowired
	private EUserMapper euserMapper;
	
	@Override
	public int registerEUser(EUser user) {
		// TODO Auto-generated method stub
		return euserMapper.registerEUser(user);
	}

	@Override
	public List<EUser> listAllEUser(Map queryMap) {
		// TODO Auto-generated method stub
		return euserMapper.listAllEUser(queryMap);
	}

	@Override
	public int updateEUser(Map updateMap) {
		// TODO Auto-generated method stub
		return euserMapper.updateEUser(updateMap);
	}

	@Override
	public EUser getEUserInfoWithAccount(int id) {
		// TODO Auto-generated method stub
		return euserMapper.getEUserInfoWithAccount(id);
	}

	@Override
	public EUser getEUserByLoginInfo(Map loginData) {
		// TODO Auto-generated method stub
		return euserMapper.getEUserByLoginInfo(loginData);
	}

}
