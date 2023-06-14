package com.spiceUp.ui;

import java.util.Scanner;

import com.spiceUp.entity.Customer;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.services.CustomerService;
import com.spiceUp.services.CustomerServiceImpl;


public class CustomerUI {

	static void displayCustomerMenu() {
		//Role of Customer
		//Register for an account by providing necessary personal information.
		//Log in to the Recipe Management System using registered credentials.
		//View a collection of recipes available in the system.
		//Filter recipes based on ingredients to find recipes that match their preferences.
		//Like or favorite recipes to save them for future reference.
		//Log out from the Recipe Management System.
		System.out.println("1. View All recipes");
		System.out.println("2. Filter recipes based on ingredients");
		System.out.println("3. Like recipes by id");
		System.out.println("0. Logout");
	}
	
	static void customerRegistration(Scanner sc) {
			//code to take input
			System.out.print("Enter username ");
			String username = sc.next();
			System.out.print("Enter password ");
			String password = sc.next();
			System.out.print("Enter email ");
			String email = sc.next();
			
			Customer cus = new Customer(username, password, email, null);
			
			try {
				CustomerService customerService = new CustomerServiceImpl();
				customerService.addCustomer(cus);
				System.out.println("Customer added successfully");
			}catch(SomeThingWentWrongException ex) {
				System.out.println(ex);
			}
	}
	
	static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			displayCustomerMenu();
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				AdminUI.viewAllRecipe();
			}
			case 2:{
				
			}
			case 3:{
				
			}
			case 0:{
				System.out.println("Thanks for using the services");
				break;
			}
			default :{
				System.out.println("Invalid choice, Try again");
			}
			}
		}while(choice != 0);
	}

	public static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
