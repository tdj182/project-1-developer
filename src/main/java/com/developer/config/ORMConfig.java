package com.developer.config;

import com.developer.models.Account;
import com.developer.models.User;
import com.developer.models.Vehicle;
import com.revature.util.Configuration;

public class ORMConfig {

	public static void config() throws NoSuchFieldException, SecurityException {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Account.class);
		
		cfg.init();
	}
}
