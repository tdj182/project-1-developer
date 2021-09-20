package com.developer.models;

import java.util.Objects;

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

	
	public User(String username, String password, int age, double weight) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
	}
	
	
	public User(int id, String username, String password, int age, double weight) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, id, password, username, weight);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", weight="
				+ weight + "]";
	}
	
	
	
}