package com.developer.models;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

@Entity(tableName="user_table")
public class User {

	@Id(columnName="user_id")
	private int id;
	
	@Column(columnName="username")
	private String username;
	
	@Column(columnName="password")
	private String password;
	
	@Column(columnName="age")
	private int age;
	
	@Column(columnName="weight")
	private double weight;
	
}