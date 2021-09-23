package com.developer.models;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

@Entity(tableName="vehicle_table")
public class Vehicle {

	@Id(columnName="id", isSerial = true)
	private int id;
	
	@Column(columnName="brand")
	private String brand;
	
	@Column(columnName="price")
	private double price;
	
	@Column(columnName="year_model")
	private int yearModel;

}