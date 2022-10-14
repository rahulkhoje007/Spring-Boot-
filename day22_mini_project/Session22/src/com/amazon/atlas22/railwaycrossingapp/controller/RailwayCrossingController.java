package com.amazon.atlas22.railwaycrossingapp.controller;

import java.util.Map;

import com.amazon.atlas22.railwaycrossingapp.db.DB;
import com.amazon.atlas22.railwaycrossingapp.model.RailwayCrossing;
import com.amazon.atlas22.railwaycrossingapp.model.User;

public class RailwayCrossingController {
	
	private static RailwayCrossingController controller;
	
	private RailwayCrossingController() {

	}
	
	public static RailwayCrossingController getInstance() {
		if(controller == null) {
			controller = new RailwayCrossingController();
		}
		
		return controller;
	}
	
	private DB db = DB.getInstance();
	
	public boolean loginUser(User user) {
		
		if(user.validate()) {
			User retrievedUser = (User)db.retrieve(user.getEmail());
			if(retrievedUser!= null && retrievedUser.getUserType() == 2) {
				user.setName(retrievedUser.getName());
				return (retrievedUser.getEmail().equalsIgnoreCase(user.getEmail()) && retrievedUser.getPassword().equals(user.getPassword()));
			}
		}
			
		return false;
	}
	
	public boolean addOrUpdateCrossing(RailwayCrossing crossing) {
		return db.set(crossing);
	}
	
	public boolean deleteCrossing(RailwayCrossing crossing) {
		return db.delete(crossing);
	}
	public boolean updateCrossing(RailwayCrossing crossings) {
		if (crossings.getStatus()==1){
			crossings.setStatus(2);
		}
		else{
			crossings.setStatus(1);
		}
		
		return db.set(crossings);
	}
	
	public Map<String, ?> fetchCrossings() {
		return db.retrieve(new RailwayCrossing());
	}
        
	public boolean deleteCrossing(Object crossings) {
		return db.delete(crossings);
	}
        public Object fetchCrossings(String name) {
		return db.retrieve(name);
	}
	
	public int getCrossingsCount() {
		return db.getCrossingsCount();
	}
}
