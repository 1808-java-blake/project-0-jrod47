//package com.revature.screens;
//
//import java.util.Scanner;
//
//import org.apache.log4j.Logger;
//
//import com.revature.beans.Account;
//import com.revature.beans.CurrentValues;
//import com.revature.beans.User;
//import com.revature.daos.AccountDao;
//import com.revature.daos.UserDao;
//import com.revature.util.AppState;
//
//public class CreateBankAccountScreen implements Screen {
//	//private CurrentValues currentValues = CurrentValues.getInstance();
//	private Scanner scan = new Scanner(System.in);
//	private AccountDao ad = AccountDao.currentAccountDao;
//	private Logger log = Logger.getRootLogger();
//	//private UserDao us = UserDao.currentUserDao;
//	private AppState state = AppState.state;
//	
//	public Screen start() {
//		User currentUser = state.getCurrentUser();
//		if(currentUser == null) {
//			return new LoginScreen();
//	}try {
//		System.out.println("");
//		Account a = new Account();
//		System.out.println("Enter new account number: ");
//		String accountNumber = scan.nextLine();
//		a.setAccountNumber(String.valueOf(accountNumber));
//		System.out.println("Enter account type: ");
//		String accountType = scan.nextLine();
//		a.setAccountType(String.valueOf(accountType));
//		a.setBalance(0);
//		a.setUserId(state.getCurrentUser().getId());
//		
//		int accountId = ad.createAccount(a);
//		if(accountId == 0) {
//			log.error("failed to create Account");
//			return new LoginScreen();
//		}
//		a.setAccountId(accountId);
//		log.info("created account" + a);
//		
//	} catch (NumberFormatException e) {
//		System.out.println("Invalid number");
//	}
//
//	return new BankOptionsScreen();
//}
//
//
//		
//		//try {
////		    ad.createAccount(a);
////			currentValues.currentAccount = a;
////			currentValues.currentUser.addaccount(a.getAccountNumber());
////			us.updateUser(currentValues.currentUser);
////		return new BankOptionsScreen();
////	}
//
//}
