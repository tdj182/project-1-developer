package com.developer;


import java.util.List;
import java.util.Scanner;

import com.developer.config.ORMConfig;
import com.developer.models.Account;
import com.developer.models.User;
import com.revature.cataclysm.Cataclysm;


public class DevDriver {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {

		// Set all configurations 
		ORMConfig.config();
		Cataclysm cc = new Cataclysm();
		 runTests(cc); // Test the methods within Cataclysm
//		Scanner scan = new Scanner(System.in);  // Create a Scanner object
//		
//		System.out.println("Enter entity name");
//		String someClass = scan.next();
//		
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
	
	public static void runTests(Cataclysm cc) {
		
		//Create a user
		User ty = new User("Ty", "pass", 30, 180.1);
		User josh = new User("Josh", "pass", 25, 180.5);
		User sebastian = new User("sebastian", "pass", 20, 180.3);
		
		ty.setId(cc.insert(ty));
		josh.setId(cc.insert(josh));
		sebastian.setId(cc.insert(sebastian));
		
		
		System.out.println("Original user: ");
		System.out.println("================");
		System.out.println(ty.toString());
		
		List<User> users = cc.selectAllFromTable(User.class);
		
		System.out.println("ALL USERS FOUND");
		System.out.println("================");
		for (User u: users) {
			System.out.println(u.getUsername());
		}
		
		User someUser = (User) cc.selectRowWithId(User.class, 2);
		

		System.out.println("USER WITH ID 2");
		System.out.println("================");
		System.out.println(someUser.getUsername());
		
		//Change user details
		ty.setAge(ty.getAge() + 1);
		ty.setWeight(ty.getWeight() + 20.5);
		ty.setPassword("BetterPass123");
		
		//Check updated user
		cc.update(ty);
		System.out.println("UPDATED USER: ");
		System.out.println("================");
		System.out.println(ty.toString());
		
		
		/////////////ACCOUNTS////////////


		Account acc1 = new Account(someUser.getId(), "My first account", 550.25);
		
		acc1.setId(cc.insert(acc1));

	}
	
}
