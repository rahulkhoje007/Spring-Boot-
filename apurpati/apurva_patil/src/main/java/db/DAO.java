/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.Map;

// Database Access Object -> Design Pattern :)
public interface DAO {
	boolean set(Object object);
	boolean delete(Object object);
	Map<String, ?> retrieve(Object object);
	Object retrieve(String key);
}
