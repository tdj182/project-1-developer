package com.developer;

import java.sql.Connection;

import com.developer.config.ORMConfig;
import com.revature.connection.ConnectionFactory;


public class DevDriver {
	
	public static void main(String[] args) {

		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = null;
		try {
			conn = cf.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conn);
		ORMConfig.config();

//		ArrayList<String> al = ReadXMLConfig.read();
//		
//		for (String s: al) {
//			System.out.println(s);
//		}
		
		
	}
	
	
}
