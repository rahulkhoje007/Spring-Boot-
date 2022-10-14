/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Map;

import db.DB;
import model.RailwayCrossing;
import model.User;

public class UserController {
	
	private static UserController controller;
	
	private UserController() {

	}
	
	public static UserController getInstance() {
		if(controller == null) {
			controller = new UserController();
		}
		
		return controller;
	}

	DB db = DB.getInstance();
	
	public boolean registerUser(User user) {

		if(user.validate())
			return db.set(user);
		else
			System.err.println("Email and Password should be non empty");
		
		return false;
	}
	
	public boolean loginUser(User user) {
		
		if(user.validate()) {
			User retrievedUser = (User)db.retrieve(user.getEmail());
			if(retrievedUser!= null && retrievedUser.getUserType() == 1) {
				user.setName(retrievedUser.getName());
				return retrievedUser.getEmail().equalsIgnoreCase(user.getEmail()) && retrievedUser.getPassword().equals(user.getPassword());
			}
		}
			
		return false;
	}
	
	public int getUserCount() {
		return db.getUserCount();
	}
	
	public Map<String, ?> refreshCrossing() {
		return db.retrieve();
	}
	
	public Map<String, ?> fetchCrossings() {
		return db.retrieve(new RailwayCrossing());
	}
	public boolean addCrossing(RailwayCrossing crossing) {
		return db.set(crossing);
	}
}

