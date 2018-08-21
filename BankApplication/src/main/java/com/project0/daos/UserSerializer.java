package com.project0.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



import com.project0.beans.User;

public class UserSerializer implements UserDao {
	
	@Override
	public void createUser(User u) {
		if (u== null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
		System.out.println(f.getName());
		if (f.exists()) {
			System.out.println("User already exists");
			return;
		}
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		if (username == null || password == null) { 
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			User u = (User) ois.readObject(); // retrieve the user if it can
			// verify that the password matches and username
			if (password.equals(u.getPassword()) && username.equals(u.getUsername())) {
				return u;
			} else {
				System.out.println("User found but password didn't match");
				return null;
			}

		} catch (FileNotFoundException e) {
			System.out.println("User Not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

}
