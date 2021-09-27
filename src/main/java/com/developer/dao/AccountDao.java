package com.developer.dao;

import java.util.List;

import com.developer.models.Account;
import com.revature.cataclysm.Cataclysm;

public class AccountDao {
	Cataclysm cc = new Cataclysm();
	public int insert(Account acc) {
		return cc.insert(acc);
	}
	
	public Account getAccount(int id) {
		return (Account) cc.selectRowWithId(Account.class, id);
	}
	
	public List<Account> getAllAccounts() {
		return cc.selectAllFromTable(Account.class);
	}
	
	// Update this to boolean later
	public boolean update(Object obj) {
		return cc.update(obj);
	}
	
	// Update this to boolean later
	public boolean delete(int id) {
		return cc.deleteById(Account.class, id);
	}
}
