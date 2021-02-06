package com.dip.mapper;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.EUser;

public interface EUserMapper {

	int registerEUser(EUser user);
	
	List<EUser> listAllEUser(Map queryMap);
	
	int updateEUser(Map updateMap);
	
	EUser getEUserInfoWithAccount(int id);
}
