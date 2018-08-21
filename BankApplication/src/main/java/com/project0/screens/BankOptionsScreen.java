package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.CurrentValues;

public class BankOptionsScreen implements Screen{
	private Scanner scan =  new Scanner(System.in);
	private CurrentValues currentValues = CurrentValues.getInstance();
	
	public Screen start() {
		System.out.println("");
		if(currentValues.currentAccount == null)System.out.println("Current Account: NO ACCOUNT");
		else System.out.println("| Current Account: " + currentValues.currentAccount.getAccountNumber() + " | Type: " + currentValues.currentAccount.getAccountType() + " | Balance: $" + currentValues.currentAccount.getBalance());
		System.out.println("");
		System.out.println("Please choose from following options: ");
		System.out.println("  ");
		System.out.println("Enter 1 to: Create a Bank Accout ");
		System.out.println("Enter 2 to: Deposit or Withdraw money ");
		System.out.println("Enter 3 to: View all transactions");
		System.out.println("Enter 4 to: Exit");
		
		String selection =  scan.nextLine();
		switch(selection) {
		case "1":		
			return new CreateBankAccountScreen();
		
		case "2":
			return new DepositOrWithdrawScreen();
			
		case "3":
			if(currentValues.currentAccount.getTransHistory() == null) {
				System.out.println("No transactions yet");
				return this;
			}
			System.out.println("Transaction History:");
			for(String history: currentValues.currentAccount.getTransHistory())
				System.out.println(history);
			return this;
			
		case "4":
			return new LoginScreen();
		
		}
		
		return this;
	}

}



