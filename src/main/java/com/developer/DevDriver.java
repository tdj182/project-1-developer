package com.developer;

import java.sql.Connection;

import com.developer.config.ORMConfig;
import com.developer.dao.UserDao;
import com.developer.models.User;
import com.revature.connection.ConnectionFactory;


public class DevDriver {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {

		// Set all configurations 
		ORMConfig.config();
		
		//Create a user
		UserDao udao = new UserDao();
		User u = new User("test", "pass", 23, 180.2);
		
		u.setId(udao.insert(u));
		System.out.println("Original user: ");
		System.out.println(u.toString());
		
		//Change user details
		u.setAge(u.getAge() + 1);
		u.setWeight(u.getWeight() + 20.5);
		u.setPassword("BetterPass123");
		
		//Check updated user
//		udao.update(u);
//		System.out.println("Updated user: ");
//		System.out.println(u.toString());

		
		
		//////////////////
//		ConnectionFactory cf = ConnectionFactory.getInstance();
//		Connection conn = null;
//		try {
//			conn = cf.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(conn);
		
		//////////////////
//		ArrayList<String> al = ReadXMLConfig.read();
//		
//		for (String s: al) {
//			System.out.println(s);
//		}
		
		
	}
	
	
}
