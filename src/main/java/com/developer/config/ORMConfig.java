package com.developer.config;

import com.developer.models.User;
import com.developer.models.Vehicle;
import com.revature.util.Configuration;

public class ORMConfig {

	public static void config() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Vehicle.class);
		
		cfg.init();
	}
}
