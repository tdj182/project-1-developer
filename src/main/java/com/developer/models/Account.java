package com.developer.models;

import java.util.Objects;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.ForeignKey;
import com.revature.annotations.Id;
import com.revature.annotations.Nullable;
import com.revature.annotations.Unique;

@Entity(tableName="accounts_table")
public class Account {
	@Id(columnName="account_id", isSerial = true)
	private int id;
	
	@ForeignKey(columnName="user_id", tableReference="user_table", columnReference="user_id")
	private int userId;

	@Column(columnName="account_name")
	@Nullable(isNullable = false)
	private String accountName;
	
	@Column(columnName="balance")
	private double balance;
	
	

	public Account() {
		super();
	}

	public Account(int userId, String accountName, double balance) {
		super();
		this.userId = userId;
		this.accountName = accountName;
		this.balance = balance;
	}
	


	public Account(int id, int userId, String accountName, double balance) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountName = accountName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountName, balance, id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountName, other.accountName)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", accountName=" + accountName + ", balance=" + balance
				+ "]";
	}
	
	
}
