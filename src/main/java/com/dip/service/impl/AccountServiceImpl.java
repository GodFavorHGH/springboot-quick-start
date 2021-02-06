package com.dip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dip.domain.concrete.Account;
import com.dip.mapper.AccountMapper;
import com.dip.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public int addEUserAccount(Account account) {
		// TODO Auto-generated method stub
		return accountMapper.addEUserAccount(account);
	}

	@Override
	public Account getAccountInfoWithEUser(int id) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountInfoWithEUser(id);
	}

	@Override
	public List<Account> getAccountListByType(List acTypes) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountListByType(acTypes);
	}

}
