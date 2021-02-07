package com.dip.service;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Account;

public interface AccountService {
	int addEUserAccount(Account account);
	Account getAccountInfoWithEUser(int id);
	List<Account> getAccountListByType(List acTypes);
	int addBatch(List<Account> accounts);
	List<Account> getAcListByUserId(int id);
	List<Account> paginationQuery(Map queryMap);
	int updateBatch(List<Account> accounts);
}
