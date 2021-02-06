package com.dip.service;

import java.util.List;

import com.dip.domain.concrete.Account;

public interface AccountService {
	int addEUserAccount(Account account);
	Account getAccountInfoWithEUser(int id);
	List<Account> getAccountListByType(List acTypes);
}
