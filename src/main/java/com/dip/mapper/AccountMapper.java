package com.dip.mapper;

import java.util.List;

import com.dip.domain.concrete.Account;

public interface AccountMapper {
	int addEUserAccount(Account account);
	Account getAccountInfoWithEUser(int id);
	List<Account> getAccountListByType(List acTypes);
}
