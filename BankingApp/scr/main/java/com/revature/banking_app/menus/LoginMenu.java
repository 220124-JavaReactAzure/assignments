package com.revature.banking_app.menus;

import java.io.BufferedReader;

import com.revature.banking_app.util.MenuRouter;

public class LoginMenu extends Menu {


	public LoginMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Login", "/login", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.print("Temp Message for login menu");
		
	}

}
