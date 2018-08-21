package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.Account;
import com.project0.beans.CurrentValues;
import com.project0.daos.AccountDao;
import com.project0.daos.UserDao;

public class CreateBankAccountScreen implements Screen {
	private CurrentValues currentValues = CurrentValues.getInstance();
	private Scanner scan = new Scanner(System.in);
	private AccountDao ad = AccountDao.currentAccountDao;
	private UserDao us = UserDao.currentUserDao;
	
	public Screen start() {
		System.out.println("");
		Account a = new Account();
		System.out.println("Enter new account number: ");
		a.setAccountNumber(scan.nextLine());
		System.out.println("Enter account type: ");
		a.setAccountType(scan.nextLine());
		a.setBalance(0);
		
		
		
		//try {
		    ad.createAccount(a);
			currentValues.currentAccount = a;
			currentValues.currentUser.addaccount(a.getAccountNumber());
			us.updateUser(currentValues.currentUser);
		return new BankOptionsScreen();
	}

}
