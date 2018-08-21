package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.CurrentValues;
import com.project0.daos.UserDao;

public class EditUserInfo implements Screen {
	private Scanner scan =  new Scanner(System.in);
	private UserDao us = UserDao.currentUserDao;
	private CurrentValues currentUser = CurrentValues.getInstance();
			

	@Override
	public Screen start() {
		System.out.println("Please choose from following options: ");
		System.out.println("  ");
		System.out.println("Enter 1 to: Edit User information");
		System.out.println("Enter 2 to: Delete User Information");
		System.out.println("Enter 3 to: Exit");
		
		String selection =  scan.nextLine();
		switch(selection) {
		case "1":
			System.out.println("Enter new username:");
			System.out.println("Enter new password");
			
			
		case "2":
			
			
		case "3":
			return new HomeScreen();
			
		default:
			break;
		}
		
		return this;
	}

}
