package com.revature.daos;

import com.revature.beans.User;

import java.sql.ResultSet;

public interface UserDao {
	public static final UserDao currentUserDao = new UserDaoJdbc();
	
	void createUser(User u);
	User findByUsernameAndPassword(String username, String password);
	void deposit(double amount, User user);
	void withdraw(double amount, User user);
	void addTransactionLog(String log, User user);

}
