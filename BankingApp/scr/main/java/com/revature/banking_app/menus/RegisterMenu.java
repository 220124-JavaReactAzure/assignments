package com.revature.banking_app.menus;

import java.io.BufferedReader;

import com.revature.banking_app.util.MenuRouter;

public class RegisterMenu extends Menu {

	

	public RegisterMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Register", "/register", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The User selected Register");

		// Things to obtain from user: first name, last name, email,username, password

		System.out.println("Please provided us with some basic information");
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();

		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();

		System.out.print("Email: ");
		String email = consoleReader.readLine();

		System.out.print("Username: ");
		String username = consoleReader.readLine();

		System.out.print("Password: ");
		String password = consoleReader.readLine();

		

		//router.transfer("/welcome");
	}

}

