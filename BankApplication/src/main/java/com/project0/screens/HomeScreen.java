package com.project0.screens;

import java.util.Scanner;

import com.project0.beans.CurrentValues;
import com.project0.daos.UserDao;

public class HomeScreen implements Screen {
	private Scanner scan =  new Scanner(System.in);
	private UserDao us = UserDao.currentUserDao;
	private CurrentValues currentUser = CurrentValues.getInstance();
	
	public Screen start() {
		System.out.println("Please choose from following options: ");
		System.out.println("  ");
		System.out.println("Enter 1 to: View Bank Options");
		System.out.println("Enter 2 to: View User Information");
		System.out.println("Enter 3 to: Edit User Information");
		System.out.println("Enter 4 to: Exit");
		
		String selection =  scan.nextLine();
		switch(selection) {
		case "1":
			return new BankOptionsScreen();
			
		case "2":
			System.out.println(currentUser.currentUser);
			
		case "3":
			return new EditUserInfo();
			
		case "4":
			System.out.println("Good Bye!!!");
			break;
		default:
			break;
		}
		
		return this;
	}

}
