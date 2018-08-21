package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class LoginScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private AppState state = AppState.state;
	
	@Override
	public  Screen start() {
		System.out.println("\n------------------------------");
		System.out.println("\nWelcome!!!");
		System.out.println("\n------------------------------");
		
		//CurrentValues currentValues = CurrentValues.getInstance();
		System.out.println("Enter Username or type Register to sign up: ");
		String username = scan.nextLine();
		if ("register".equalsIgnoreCase(username)) {
			return new SingUpScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();

		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			state.setCurrentUser(currentUser); 
			return new BankOptionsScreen(currentUser);
		}

		System.out.println("unable to login");
		return this;
	}

}
