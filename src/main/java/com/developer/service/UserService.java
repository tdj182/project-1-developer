package com.developer.service;

import java.util.List;
import java.util.Scanner;

import com.developer.dao.UserDao;
import com.developer.models.User;
import com.developer.util.HelperMethods;

public class UserService {

	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	UserDao udao = new UserDao();
	
	public int insert() {
		System.out.println("Enter a username");
		String username = scan.next();
		System.out.println("Enter a password");
		String password = scan.next();

		int age = HelperMethods.getIntInput("Enter your age");
		double weight = HelperMethods.getAnyDoubleInput("Enter your weight");
		
		return udao.insert(new User(username, password, age, weight));
	}
	
	public List<User> getAllUsers() {
		return udao.getAllUsers();
	}
	
	public User getUser() {
		int userId = HelperMethods.getIntInput("Enter a valid User ID");
		return udao.getUser(userId);
	}
	
	public boolean updateUser() {
		User u = getUser();
		System.out.println("Enter a new username");
		u.setUsername(scan.next());
		System.out.println("Enter a new password");
		u.setPassword(scan.next());

		u.setAge(HelperMethods.getIntInput("Enter your age"));
		u.setWeight(HelperMethods.getAnyDoubleInput("Enter your weight")); 
		
		return udao.update(u);
	}
	
	public boolean deleteUser() {
		int userId = HelperMethods.getIntInput("Enter a valid User ID");
		return udao.delete(userId);
	}
}
