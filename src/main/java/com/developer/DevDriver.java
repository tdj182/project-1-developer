package com.developer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.developer.config.ORMConfig;
import com.developer.models.Account;
import com.developer.models.User;
import com.developer.service.AccountService;
import com.developer.service.UserService;
import com.revature.cataclysm.Cataclysm;


public class DevDriver {
	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {

		// Set all configurations 
		ORMConfig.config();
		
		runTests();
		runApp();
		runCustomSql();
	}
	
	public static void runApp() {
		boolean isRunning = true;
		while (isRunning) {
			
			boolean isValidInput = false;
			int input = 0;
			while (!isValidInput) {
				try {
					System.out.println("Press 1 to Access User Methods"
										+ "\nPress 2 to Access Account Methods"
										+ "\nPress 0 to Quit");
					
					input = scan.nextInt();
					
					//Validate input
					if (input >= 0 && input <= 2)
						isValidInput = true;
					else
						System.out.println("Invalid input.");
				} catch (InputMismatchException  e) {
					System.out.println("Invalid input.");
					scan.nextLine(); //Clear invalid input
				}
			}
			
			switch (input) {
			case 1:
				UserOptions();
				break;
			case 2:
				AccountOptions();
				break;
			default:
				System.out.println("Exiting Application");
				isRunning = false;
				
			}
			

		}
	}

	public static void UserOptions() {
		UserService userv = new UserService();
		User retrievedUser = new User();
		List<User> allUsers = new ArrayList<>();
		
		boolean isRunning = true;
		while (isRunning) {
			boolean isValidInput = false;
			int input = 0;
			while (!isValidInput) {
				try {
					System.out.println("Press 1 to GET All users"
										+ "\nPress 2 to CREATE a new user" 
										+ "\nPress 3 to GET user by ID" 
										+ "\nPress 4 to UPDATE a user"  
										+ "\nPress 5 to DELETE a user" 
										+ "\nPress 0 to Exit user");
					
					input = scan.nextInt();
					
					//Validate input
					if (input >= 0 && input <= 5)
						isValidInput = true;
					else
						System.out.println("Invalid input.");
				} catch (InputMismatchException  e) {
					System.out.println("Invalid input.");
					scan.nextLine(); //Clear invalid input
				}
			}
			
			switch (input) {
			case 1: // GET ALL USERS
				allUsers = userv.getAllUsers();
				if (!allUsers.isEmpty()) {
					for (User u: allUsers) {
						System.out.println(u.toString());
					}
				} else {
					System.out.println("No users in table");
				}
				break;
			case 2: // CREATE A NEW USER
				int id = userv.insert();
				if (id > 0) {
					System.out.println("New user created with ID of " + id);
				} else {
					System.out.println("Error occured while creating user");
				}
				break;
			
			case 3: // GET USER BY ID
				retrievedUser = userv.getUser();
				if (retrievedUser != null) {
					System.out.println(retrievedUser.toString());
				} else {
					System.out.println("User not found");
				}
				break;
				
			case 4: // UPDATE A USER
				boolean didUpdate = userv.updateUser();
				if (didUpdate == true) {
					System.out.println("User successfully updated");
				} else {
					System.out.println("User did not update successfully");
				}
				break;
				
			case 5: // DELETE A NEW USER
				boolean didDelete = userv.deleteUser();
				if (didDelete) {
					System.out.println("User successfully deleted");
				} else {
					System.out.println("User did not delete successfully");
				}
				break;
				
			default:
				System.out.println("Exiting Users");
				isRunning = false;
			}
		}
		
	}
	
	public static void AccountOptions() {
		AccountService aserv = new AccountService();
		Account retrievedAccount= new Account();
		List<Account> allAccounts = new ArrayList<>();
		
		boolean isRunning = true;
		while (isRunning) {
			boolean isValidInput = false;
			int input = 0;
			while (!isValidInput) {
				try {
					System.out.println("Press 1 to GET All accounts"
										+ "\nPress 2 to CREATE a new account" 
										+ "\nPress 3 to GET account by ID" 
										+ "\nPress 4 to UPDATE a account"  
										+ "\nPress 5 to DELETE a account" 
										+ "\nPress 0 to Exit accounts");
					
					input = scan.nextInt();
					
					//Validate input
					if (input >= 0 && input <= 5)
						isValidInput = true;
					else
						System.out.println("Invalid input.");
				} catch (InputMismatchException  e) {
					System.out.println("Invalid input.");
					scan.nextLine(); //Clear invalid input
				}
			}
			
			switch (input) {
			case 1: // GET ALL ACCOUNTS
				allAccounts = aserv.getAllAccounts();
				if (!allAccounts.isEmpty()) {
					for (Account a: allAccounts) {
						System.out.println(a.toString());
					}
				} else {
					System.out.println("No accounts in table");
				}
				break;
			case 2: // CREATE A NEW ACCOUNT
				int id = aserv.insert();
				if (id > 0) {
					System.out.println("New account created with ID of " + id);
				} else {
					System.out.println("Error occured while creating user");
				}
				break;
			
			case 3: // GET ACCOUNT BY ID
				retrievedAccount = aserv.getAccount();
				if (retrievedAccount != null) {
					System.out.println(retrievedAccount.toString());
				} else {
					System.out.println("Account not found");
				}
				break;
				
			case 4: // UPDATE AN ACCOUNT
				boolean didUpdate = aserv.updateAccount();
				if (didUpdate == true) {
					System.out.println("Account successfully updated");
				} else {
					System.out.println("Account did not update successfully");
				}
				break;
				
			case 5: // DELETE AN ACCOUNT
				boolean didDelete = aserv.deleteAccount();
				if (didDelete) {
					System.out.println("Account successfully deleted");
				} else {
					System.out.println("Account did not delete successfully");
				}
				break;
				
			default:
				System.out.println("Exiting Accounts");
				isRunning = false;
			}
		}
		
	}
	
	public static void listAllEntities() {
//		String someClass = scan.next();
//		Class c2 = null;
////		c2 = someClass.getClass();
//		try {
//			c2 = Class.forName("com.developer.models." + someClass);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(c2);
//		List<User> users = cc.selectAllFromTable(c2);
//
//		System.out.println("ALL USERS FOUND");
//		System.out.println("================");
//		for (User u: users) {
//			System.out.println(u.getUsername());
//		}
	}
	
	
	public static void runTests() {
		

		Cataclysm cc = new Cataclysm();
		//Create a user
		User ty = new User("Ty", "pass", 30, 180.1);
		User josh = new User("Josh", "pass", 25, 180.5);
		User sebastian = new User("sebastian", "pass", 20, 180.3);
		
		ty.setId(cc.insert(ty));
		josh.setId(cc.insert(josh));
		sebastian.setId(cc.insert(sebastian));
		
		List<User> users = cc.selectAllFromTable(User.class);
		
		System.out.println("ALL USERS");
		System.out.println("================");
		for (User u: users) {
			System.out.println(u.getUsername());
		}
		
		User someUser = (User) cc.selectRowWithId(User.class, 2);
		

		System.out.println("USER WITH ID 2");
		System.out.println("================");
		System.out.println(someUser.getUsername());
		
		
		
		/////////////ACCOUNTS////////////


		Account acc1 = new Account(someUser.getId(), "My first account", 550.25);
		
		acc1.setId(cc.insert(acc1));

		System.out.println(acc1.toString());
		
	
	}
	
	public static void runCustomSql() {
		
	}
	
}
