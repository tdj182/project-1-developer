package com.developer.dao;

import java.sql.Connection;

import com.developer.models.User;
import com.revature.connection.ConnectionFactory;
import com.revature.objectMapper.Database;

public class UserDao {
	Database db = new Database();
	public int insert(User user) {
		return db.insert(user);
	}
	
	// Update this to boolean later
	public void update(Object obj) {
		db.update(obj);
	}
}
