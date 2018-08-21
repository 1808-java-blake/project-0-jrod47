//package com.revature.screens;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.revature.beans.Account;
//import com.revature.beans.CurrentValues;
//import com.revature.beans.User;
//import com.revature.daos.AccountDao;
//import com.revature.util.AppState;
//
//
//public class DepositOrWithdrawScreen implements Screen{
//	private Scanner scan =  new Scanner(System.in);
//	private CurrentValues currentValues = CurrentValues.getInstance();
//	private AccountDao ad = AccountDao.currentAccountDao;
//	private AppState state = AppState.state;
//	
//	public Screen start() {
//		User currentUser = state.getCurrentUser();
//		List<Account> currentAccount = new ArrayList();
//		if (currentUser == null) {
//			return new LoginScreen();
//		}
//		
////		List<Account>  accounts = ad.findByUserId(state.getCurrentAccount().getUserId());
////		
////		if(accounts == null) {
////			return new LoginScreen();
//	//}
////		if(currentValues.currentAccount == null)System.out.println("Current Account: NO ACCOUNT");
////		else System.out.println("| Current Account: " + currentValues.currentAccount.getAccountNumber() + " | Type: " + currentValues.currentAccount.getAccountType() + " | Balance: $" + currentValues.currentAccount.getBalance());
////		System.out.println("");
//		//User currentUser = state.getCurrentUser();
////		Account currentAccount = new Account();
////		if (currentUser == null) {
////			return new LoginScreen();
////		}
//		
//		System.out.println("Please choose from following options: ");
//		System.out.println("  ");
//		System.out.println("Enter 1 to: Deposit Money ");
//		System.out.println("Enter 2 to: Withdraw Money ");
//		System.out.println("Enter 3 to: Exit");
//		
//		String selection =  scan.nextLine();
//		
//		switch(selection) {
//		case "1":
////			System.out.println("Enter amount to deposit");
////			String depAmount = scan.nextLine();
////			//a.depositFunds(String.valueOf(depAmount));
////			//state.currentAccount.depositFunds(depAmount);
////			Accoun.currentAccountDao.depositFunds(Double.valueOf(depAmount));;
////			ad.updateAccount(currentValues.currentAccount);
////			
////			//AccountDao.currentAccountDao.deposit(Double.valueOf(amount), user);
////			
//			
//			int balance;
//			currentAccount = ad.findByUserId(currentUser.getId());
//			state.getCurrentAccount();
//			System.out.println(currentAccount);
//			System.out.println(state.getCurrentAccount());
//			System.out.println("How much would you like to withdraw?");
//			System.out.println("Balance: " + ((Account) currentAccount).getBalance());
//			String withdrawAmount = scan.nextLine();
//			if (Double.valueOf(withdrawAmount) > ((Account) currentAccount).getBalance()) {
//				System.out.println("You don't have the coin mate");
//			} else {
//				currentAccount.setTransactionHistory("-" + withdrawAmount);
//				System.out.println(withdrawAmount + currentAccount.getBalance());
//				System.out.println(balance = (-Integer.valueOf(withdrawAmount)) + currentAccount.getBalance());
//				currentAccount.setBalance(balance);
//				System.out.println(currentAccount.getBalance());
//				ad.updateAccount(currentAccount);
//			}
//		} catch (NumberFormatException e) {
//			System.out.println("Invalid number");
//		}
//
//		return this;
//	}
//
//}
//		case "2":
//			System.out.println("Enter amount to withdraw");
//			String withAmount = scan.nextLine();
//			//currentValues.currentAccount.withdrawFunds(withAmount);
//			ad.updateAccount(currentValues.currentAccount);
//			return this;
//		
//		case "3":
//			return new BankOptionsScreen();
//		}
//		
//		return this;
//	}
//
//}
//
//
//
