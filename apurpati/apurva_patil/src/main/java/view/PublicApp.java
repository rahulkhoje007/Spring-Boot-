/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import controller.RailwayCrossingController;
import controller.UserController;
import model.RailwayCrossing;
import model.User;

public class PublicApp {

	UserController controller;
	RailwayCrossingController railController;
	Scanner scanner;

	private static PublicApp app;

	public static PublicApp getInstance() {
		if (app == null) {
			app = new PublicApp();
		}
		return app;
	}

	private PublicApp() {
		controller = UserController.getInstance();
		railController = RailwayCrossingController.getInstance();
		scanner = new Scanner(System.in);
	}

	void register() {
		User user = new User();

		// Empty Next Line for Scanner Issue
		scanner.nextLine();

		System.out.println("Enter Name: ");
		user.setName(scanner.nextLine());

		System.out.println("Enter Email: ");
		user.setEmail(scanner.nextLine());

		System.out.println("Enter Password: ");
		user.setPassword(scanner.nextLine());

		user.setUserType(1);

		if (controller.registerUser(user)) {
			System.out.println(user.getName() + ", You have Registered Successfully..");
			System.out.println("Navigating to the Railway Crossing Application");

			// Navigate to Home
			home();

		} else {
			System.err.println("Something Went Wrong. Please Try Again");
		}
	}

	void login() {
		User user = new User();

		// Empty Next Line for Scanner Issue
		scanner.nextLine();

		System.out.println("Enter Email: ");
		user.setEmail(scanner.nextLine());

		System.out.println("Enter Password: ");
		user.setPassword(scanner.nextLine());

		user.setUserType(1);

		if (controller.loginUser(user)) {
			System.out.println(user.getName() + ", You have Logged In Successfully..");
			System.out.println("Navigating to the Railway Crossing Application");

			// Navigate to Home
			home();
		} else {
			System.err.println("Something Went Wrong. Please Try Again");
		}
	}

	void searchCrossings(String name) {

		Object crossings = railController.fetchCrossings(name);
		System.out.println(crossings);
		System.out.println("-------------------------------");

	}

	void listCrossings() {
		Map<String, RailwayCrossing> crossings = (Map<String, RailwayCrossing>) railController.fetchCrossings();
		for (String key : crossings.keySet()) {
			System.out.println(crossings.get(key));
			System.out.println("-------------------------------");
		}
	}

	void home() {

		while (true) {

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Welcome to Railway Crossing Home");
			System.out.println("1: List Railway Crossings");
			System.out.println("2: Search Railway Crossings");
			System.out.println("3: Sort Railway Crossings by Schedule");
			System.out.println("4: Close Public Application");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			int choice = scanner.nextInt();
			switch (choice) {

			case 1:
				listCrossings();
				break;

			case 2:
				scanner.nextLine();
				System.out.println("Enter the email of PersonInCharge of crossing you want to search:");
				String name = scanner.nextLine();
				searchCrossings(name);
				break;

			case 3:
				sortBySchedule();
				break;

			case 4:
				System.out.println("Thank You for using Railway Crossing App");
				break;

			default:
				System.err.println("Invalid Choice");
			}

			if (choice == 4) {
				break;
			}
		}
	}

	public void sortBySchedule() {
		System.out.println("We are in sortBYSchedule: ");
		System.out.println("Note::::: Time should be in 2 digit (like 02,10 etc) to see proper sort operation");
		try {
			TreeMap<String, RailwayCrossing> sortedMap = new TreeMap<>();
			Map<String, RailwayCrossing> crossings = (Map<String, RailwayCrossing>) controller.fetchCrossings();
			// System.out.println("keys: "+crossings.keySet());
			for (String key : crossings.keySet()) {
				// System.out.println("Schedule"+crossings.get(key).getSchedules());
				//System.out.println(crossings.get(key));
				//System.out.println("-------------------------------");
				LinkedHashMap<String, String> schedules = crossings.get(key).getSchedules();

				for (String keyShedule : schedules.keySet()) {
					sortedMap.put(schedules.get(keyShedule), crossings.get(key));
				}

			}

			// System.out.println("Schedule Tree Map"+sortedMap);

			LinkedHashMap<String, RailwayCrossing> schedulesNew = new LinkedHashMap<>();
			controller.refreshCrossing();
			for (Entry<String, RailwayCrossing> entry : sortedMap.entrySet()) {
				String key1 = entry.getKey();
				RailwayCrossing val1 = entry.getValue();
				schedulesNew.put(val1.getName(), val1);
				controller.addCrossing(val1);
			}

			Map<String, RailwayCrossing> crossings2 = (Map<String, RailwayCrossing>) controller.fetchCrossings();
			for (String key : crossings2.keySet()) {
				// System.out.println("key2: "+key);
				// System.out.println("value2"+crossings2.get(key));
				System.out.println(crossings.get(key));
				System.out.println("-------------------------------");
				// System.out.println("Schedule2"+crossings2.get(key).getSchedules());
			} // crossings.get(key).setSchedules(schedulesNew);
				// System.out.println("Schedule new"+crossings.get(key).getSchedules());
		} catch (Exception e) {
			System.out.println("Data is wrong hence exception occurs");
		}

	}

	void startPublicApp() {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome User");
		System.out.println("We have " + controller.getUserCount() + " Users in the DataBase");
		System.out.println("1: Register");
		System.out.println("2: Login");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int choice = scanner.nextInt();
		switch (choice) {

		case 1:
			register();
			break;

		case 2:
			login();
			break;

		default:
			System.err.println("Invalid Choice");
		}
	}

}
