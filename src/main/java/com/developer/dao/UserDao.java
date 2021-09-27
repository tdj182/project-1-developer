package com.developer.dao;

import java.util.List;

import com.developer.models.User;
import com.revature.cataclysm.Cataclysm;

public class UserDao {
	Cataclysm cc = new Cataclysm();
	public int insert(User user) {
		return cc.insert(user);
	}
	
	public User getUser(int id) {
		return (User) cc.selectRowWithId(User.class, id);
	}
	
	public List<User> getAllUsers() {
		return cc.selectAllFromTable(User.class);
	}
	
	// Update this to boolean later
	public boolean update(Object obj) {
		return cc.update(obj);
	}
	
	// Update this to boolean later
	public boolean delete(int id) {
		return cc.deleteById(User.class, id);
	}
}
