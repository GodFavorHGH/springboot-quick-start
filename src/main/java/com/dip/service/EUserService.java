package com.dip.service;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.EUser;

public interface EUserService {

    int registerEUser(EUser user);

    List<EUser> listAllEUser(Map queryMap);

    int updateEUser(Map updateMap);

    EUser getEUserInfoWithAccount(int id);

    EUser getEUserByLoginInfo(String phone, String password);

    int updateByEUser(EUser user);
}
