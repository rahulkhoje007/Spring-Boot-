/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.LinkedHashMap;
import java.util.Map;

import model.RailwayCrossing;
import model.User;

public class DB implements DAO{

	// users is a collection which will hold User Objects, BUT Temporarily i.e. till the application is running
	private LinkedHashMap<String, User> users = new LinkedHashMap<String, User>();

	// crossings is a collection which will hold Railway Crossing Objects, BUT Temporarily i.e. till the application is running
	private LinkedHashMap<String, RailwayCrossing> crossings = new LinkedHashMap<String, RailwayCrossing>();
	
	private static DB db;
	
	private DB(){
		populateAdminUsers();
	}
	
	// Singleton Design Pattern
	public static DB getInstance() {
		if(db == null) {
			db = new DB();
		}
		
		return db;
	}
	
	void populateAdminUsers() {
		User user1 = new User("Harry", "harry@example.com", "harry123", 2);
		User user2 = new User("Apurva", "apurva@amazon.com", "apurva123", 2);
		User user3 = new User("Arohi", "ar@gmail.com", "ar123", 1);
		set(user1);
		set(user2);
		set(user3);

	}
	
	// Performs both insert and update
	public boolean set(Object object) {
		if(object instanceof User) {
			User user = (User)object;
			users.put(user.getEmail(), user);
			return true;
		}else {
			RailwayCrossing crossing = (RailwayCrossing)object;
			crossings.put(crossing.getName(), crossing);
			return true;
		}
	}
	
	public boolean delete(Object object) {
		if(object instanceof User) {
			User user = (User)object;
			users.remove(user.getEmail());
			return true;
		}else {
			RailwayCrossing crossing = (RailwayCrossing)object;
			crossings.remove(crossing.getName());
			return true;
		}
	}
	
	public Map<String, ?> retrieve(Object object) {
		if(object instanceof User) {
			return users;
		}else {
			return crossings;
		}
	}
	
	public Map<String, ?> retrieve() {
		 crossings = new LinkedHashMap<String, RailwayCrossing>();
			return crossings;
	}
	
	@Override
	public Object retrieve(String key) {
		
		if(users.containsKey(key)) {
			return users.get(key);
		}else if (crossings.containsKey(key)){
			return crossings.get(key);
		}else {
			return null;
		}
	}
	
	public int getUserCount() {
		return users.size();
	}
	
	public int getCrossingsCount() {
		return crossings.size();
	}
	
}

