package com.dip.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public int addBatch(List<Account> accounts) {
		// TODO Auto-generated method stub
		return accountMapper.addBatch(accounts);
	}

	@Override
	public List<Account> getAcListByUserId(int id) {
		// TODO Auto-generated method stub
		return accountMapper.getAcListByUserId(id);
	}

	@Override
	public List<Account> paginationQuery(Map queryMap) {
		// TODO Auto-generated method stub
		return accountMapper.paginationQuery(queryMap);
	}

	@Override
	public int updateBatch(List<Account> accounts) {
		// TODO Auto-generated method stub
		return accountMapper.addBatch(accounts);
	}

}
