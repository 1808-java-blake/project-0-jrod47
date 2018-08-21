package com.project0.launcher;

import com.project0.screens.LoginScreen;
import com.project0.screens.Screen;

public class Laucher {

	public static void main(String[] args) {
		
		Screen s = new LoginScreen();
		while(true) {
			s = s.start();
		}
	}

}
