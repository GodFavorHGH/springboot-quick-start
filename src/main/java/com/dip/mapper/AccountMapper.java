package com.dip.mapper;

import java.util.List;
import java.util.Map;

import com.dip.domain.concrete.Account;

@SuppressWarnings({"rawtypes"})
public interface AccountMapper {
    int addEUserAccount(Account account);

    Account getAccountInfoWithEUser(int id);

    List<Account> getAccountListByType(List acTypes);

    int addBatch(List<Account> accounts);

    List<Account> getAcListByUserId(int id);

    List<Account> paginationQuery(Map queryMap);

    int updateBatch(List<Account> accounts);
}
