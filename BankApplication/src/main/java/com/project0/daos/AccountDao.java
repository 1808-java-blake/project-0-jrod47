package com.project0.daos;

import com.project0.beans.Account;

public interface AccountDao {
	public static final AccountDao currentAccountDao = new AccountSerializer();
	
	void createAccount(Account acc);
	Account findByAccountNumber(String accountNumber);
	void updateAccount(Account acc);
	void deleteAccount(Account acc);

}

