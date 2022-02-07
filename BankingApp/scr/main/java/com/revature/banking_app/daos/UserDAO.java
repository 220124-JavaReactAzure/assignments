package com.revature.banking_app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.banking_app.models.User;
import com.revature.banking_app.util.ConnectionFactory;
import com.revature.banking_app.util.LinkedList;
import com.revature.banking_app.util.List;

public class UserDAO implements CrudDAO<User> {


	// TODO: Implement Authentication
	public User findByUsernameAndPassword(String username, String password) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	// TODO: Implement FindByEmail
	public User findByEmail(String email) {
		return null;
	}
	
	// TODO: Implement FindByUsername
	public User findByUsername(String username) {
		return null;
	}

	@Override
	public User create(User newUser) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			newUser.setUserId(UUID.randomUUID().toString());
			
			String sql = "insert into users (user_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUser.getUserId());
			ps.setString(2, newUser.getFirstName());
			ps.setString(3, newUser.getLastName());
			ps.setString(4, newUser.getEmail());
			ps.setString(5, newUser.getUsername());
			ps.setString(6, newUser.getPassword());
			
			int rowsInserted = ps.executeUpdate();
			
			if(rowsInserted != 0) {
				return newUser;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public List<User> findAll() {
		
		List<User> usersList = new LinkedList<>(); 
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users";
			Statement s = conn.createStatement();
			
			ResultSet resultSet = s.executeQuery(sql);
			
			
			while(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getString("user_id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				
				usersList.add(user);
			}	
			
			return usersList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
