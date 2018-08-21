package com.revature.screens;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.AppState;


public class BankOptionsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private String userTransactionLog;
	private AppState state = AppState.state;
	UserDao ud = UserDao.currentUserDao;

	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public Screen start() {
		User currentUser = state.getCurrentUser();
		if(currentUser == null) {
			return new LoginScreen();
		}
		
		System.out.println("\n******************************");
		System.out.println("\n Welcome to the Home Menu: ");
		System.out.println("\n******************************");
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1 to: Deposit Money");
		System.out.println("Enter 2 to: Withdraw Money");
		System.out.println("Enter 3 to: View current balance");
		System.out.println("Enter 4 to: View all transactions history");
		System.out.println("Enter 5 to: Return to Login");

		String selection = scan.nextLine();
		switch (selection){
			case "1":
					System.out.println("\n------------------------------");
					System.out.println("\nWhant to Deposit?");
					System.out.println("\n------------------------------");
					System.out.println("Enter amount you want to deposit:");
					String depAmount = scan.nextLine();
					UserDao.currentUserDao.deposit(Double.valueOf(depAmount), currentUser);

					userTransactionLog = "You deposited: " + formatter.format(Integer.valueOf(depAmount));
					System.out.println(userTransactionLog);

					userTransactionLog = userTransactionLog + " on " + dtf.format(LocalDateTime.now());
					UserDao.currentUserDao.addTransactionLog(userTransactionLog, currentUser);
					break;
			case "2":
					System.out.println("\n------------------------------");
					System.out.println("\nWhant to Withdraw?");
					System.out.println("\n------------------------------");
					System.out.println("Enter amount you want to withdraw: ");
					String withAmount = scan.nextLine();

					if(Double.valueOf(withAmount) > currentUser.getBalance()){
						System.out.println("You don't have enough funds in this account.");
						break;
					}

					UserDao.currentUserDao.withdraw(Double.valueOf(withAmount), currentUser);
					userTransactionLog = "You withdraw: " + formatter.format((Integer.valueOf(withAmount)));
					System.out.println(userTransactionLog);

					userTransactionLog = userTransactionLog + " on " + dtf.format(LocalDateTime.now());
					UserDao.currentUserDao.addTransactionLog(userTransactionLog, currentUser);

				break;
			case "3":
					System.out.println("\n------------------------------");
					System.out.println("\nHello, " + currentUser.getFirstName() +" "+ currentUser.getLastName());
					System.out.println("\nYour current balance is: " + formatter.format(currentUser.getBalance()));
					System.out.println("\n------------------------------");
						
				break;
			case "4":
					System.out.println("\n------------------------------");
					System.out.println("\nYour transaction history is:");
					System.out.println(currentUser.getLog().replaceAll("null", ""));
					System.out.println("\n------------------------------");
					break;
			case "5":
				return new LoginScreen();
				default:
					break;
		}
		return this;
	}

}



