package com.revature.banking_app.services;

import com.revature.banking_app.daos.UserDAO;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.models.User;
import com.revature.banking_app.util.List;

public class UserService {

	private UserDAO userDao = new UserDAO();
	
	public boolean registerNewUser(User newUser) {
		if(!isUserValid(newUser)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

		// TODO: Write logic that verifies the new users information isn't duplicated int he system
		userDao.create(newUser);
		

		return true;
	}
	
	public List<User> getAllUsers(){
		return userDao.findAll();		
	}
	
	//TODO: Impelement authentication
	public User autenticateUser(String username, String password) {
		userDao.findByUsernameAndPassword(username, password);
		return null;
	}

	public boolean isUserValid(User newUser) {
		if(newUser == null) return false;
		if(newUser.getFirstName() == null || newUser.getFirstName().trim().equals("")) return false;
		if(newUser.getLastName() == null || newUser.getLastName().trim().equals("")) return false;
		if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) return false;
		if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) return false;
		return newUser.getPassword() != null || !newUser.getPassword().trim().equals("");


	}
	
}
