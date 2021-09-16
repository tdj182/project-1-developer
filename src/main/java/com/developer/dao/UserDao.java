package com.developer.dao;

import java.sql.Connection;

import com.developer.models.User;
import com.revature.connection.ConnectionFactory;

public class UserDao {
	public int insert(User user) {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = null;
		try {
			conn = cf.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1; // return the auto-generate primary key
	}
}
