package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project0.beans.User;
import com.project0.daos.UserDao;
import com.project0.screens.BankOptionsScreen;
import com.project0.screens.Screen;
import com.project0.screens.SingUpScreen;


public class LoginScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();

	@Override
	public Screen start() {
		log.debug("started login screen");

		System.out.println("\n---! Enter Username or type Register to sign up: !---");
		String username = scan.nextLine();
		log.trace("username = " + username);
		if ("register".equalsIgnoreCase(username)) {
			return new SingUpScreen();
		}

		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		log.debug("received users credentials");
		User currentUser = ud.findByUsernameAndPassword(username, password);

		if (currentUser != null) {
			log.info("user succefully logged in");
			return new BankOptionsScreen();
		}

		System.out.println("unable to login");
		return this;
	}

}