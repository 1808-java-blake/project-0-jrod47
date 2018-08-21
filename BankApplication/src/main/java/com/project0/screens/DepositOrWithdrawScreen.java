package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.CurrentValues;
import com.project0.daos.AccountDao;


public class DepositOrWithdrawScreen implements Screen{
	private Scanner scan =  new Scanner(System.in);
	private CurrentValues currentValues = CurrentValues.getInstance();
	private AccountDao ad = AccountDao.currentAccountDao;
	
	public Screen start() {
		if(currentValues.currentAccount == null)System.out.println("Current Account: NO ACCOUNT");
		else System.out.println("| Current Account: " + currentValues.currentAccount.getAccountNumber() + " | Type: " + currentValues.currentAccount.getAccountType() + " | Balance: $" + currentValues.currentAccount.getBalance());
		System.out.println("");
		System.out.println("Please choose from following options: ");
		System.out.println("  ");
		System.out.println("Enter 1 to: Deposit Money ");
		System.out.println("Enter 2 to: Withdraw Money ");
		System.out.println("Enter 3 to: Exit");
		
		String selection =  scan.nextLine();
		switch(selection) {
		case "1":
			System.out.println("Enter amount to deposit");
			String depAmount = scan.nextLine();
			currentValues.currentAccount.depositFunds(depAmount);
			ad.updateAccount(currentValues.currentAccount);
			return this;
			
		case "2":
			System.out.println("Enter amount to withdraw");
			String withAmount = scan.nextLine();
			currentValues.currentAccount.withdrawFunds(withAmount);
			ad.updateAccount(currentValues.currentAccount);
			return this;
		
		case "3":
			return new BankOptionsScreen();
		}
		
		return this;
	}

}



