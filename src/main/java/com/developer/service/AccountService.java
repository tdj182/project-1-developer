package com.developer.service;

import java.util.List;
import java.util.Scanner;

import com.developer.dao.AccountDao;
import com.developer.dao.UserDao;
import com.developer.models.Account;
import com.developer.models.User;
import com.developer.util.HelperMethods;

public class AccountService {
	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	AccountDao adao = new AccountDao();
	UserService userv = new UserService();
	
	public int insert() {
		User u = userv.getUser();
		if (u != null) {
			System.out.println("Enter an account name");
			String accountName = scan.nextLine();
			double balance = HelperMethods.getPositiveDoubleInput("Input inital balance");
			return adao.insert(new Account(u.getId(), accountName, balance));
		}
		
		return -1;
		
	}
	
	public List<Account> getAllAccounts() {
		return adao.getAllAccounts();
	}
	
	public Account getAccount() {
		int accountId = HelperMethods.getIntInput("Enter a valid Account ID");
		return adao.getAccount(accountId);
	}
	
	public boolean updateAccount() {
		Account acc = getAccount();

		System.out.println("Enter a new account name");
		acc.setAccountName(scan.nextLine());
		acc.setBalance(HelperMethods.getPositiveDoubleInput("Input new balance"));
		return adao.update(acc);
		
	}
	
	public boolean deleteAccount() {
		int accountId = HelperMethods.getIntInput("Enter a valid Account ID");
		return adao.delete(accountId);
	}
}
