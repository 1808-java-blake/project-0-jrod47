package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.User;
import com.project0.daos.UserDao;

public class SingUpScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao us = UserDao.currentUserDao;

	@Override
	public Screen start() {
		User u = new User();
		System.out.println("Enter Username: ");
		u.setUsername(scan.nextLine());
		System.out.println("Enter Password: ");
		u.setPassword(scan.nextLine());
		System.out.println("Enter First Name: ");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter Last Name: ");
		u.setLastName(scan.nextLine());
		System.out.println("Are you an admin? 'y' for yes or 'n' for no");
		String yesOrNo = scan.nextLine();
		if(yesOrNo.equals("y"))
			u.setAdmin(true);
		else u.setAdmin(false);
		
		//try {
		us.createUser(u);
		

	return new LoginScreen();

}

}

