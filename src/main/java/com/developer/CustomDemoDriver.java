package com.developer;

import com.developer.models.User;
import com.revature.cataclysm.Cataclysm;
import com.revature.customStatement.Create;
import com.revature.customStatement.CustomColumn;
import com.revature.customStatement.Delete;
import com.revature.customStatement.Insert;
import com.revature.customStatement.Select;
import com.revature.customStatement.Update;

public class CustomDemoDriver {
		
		public static void main(String[] args) throws NoSuchFieldException, SecurityException {
			
			Cataclysm cataclysm = new Cataclysm();
			
			// Create table with FK's, different constraints, etc	
			CustomColumn c = new CustomColumn("acc_owner")
					.datatype("SERIAL")
					.primaryKey(true);
			
			CustomColumn c2 = new CustomColumn("partner")
					.datatype("INTEGER")
					.constraint("NOT NULL")
					.reference("user_table(user_id)")
					.deleteCascade(true);
			
			CustomColumn c3 = new CustomColumn("username")
					.datatype("VARCHAR(50)")
					.constraint("UNIQUE");
			
			
			Create table = new Create("new_table")
					.column(c)
					.column(c2)
					.column(c3);
			
//			cataclysm.customCreate(table.toString());
			
			// INSERT ROW
			Insert i = new Insert("new_table")
					.set("partner", "1")
					.set("username", "'newaccount'");
		
//			cataclysm.customInsert(i.toString());
			
			
			// UPDATE
			Update u = new Update("new_table")
					.where("partner = 1")
					.set("username = 'jmligz'");
			
//			cataclysm.customUpdate(u.toString());
			
			// DELETE
			Delete d = new Delete("new_table")
					.where("username = 'jmligz'");
			
//			cataclysm.customDelete(d.toString());
			
			
			Select select = new Select("user_table")
					.column("username")
					.column("password")
					.where("age = 25");
			
			
			User returnedUser = (User) cataclysm.customSelect(User.class, select.toString());
			System.out.println(returnedUser.getUsername() + " " + returnedUser.getPassword());
			
		}

		
		
		

}
