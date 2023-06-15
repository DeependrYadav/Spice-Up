package com.spiceUp.ui;

import java.util.HashSet;
import java.util.Scanner;

import com.spiceUp.dao.CustomerDAO;
import com.spiceUp.dao.CustomerDAOImpl;
import com.spiceUp.entity.Customer;
import com.spiceUp.entity.IsDeleted;
import com.spiceUp.entity.LoggedInUserId;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.javaFrame.Messages;
import com.spiceUp.javaFrame.Print;
import com.spiceUp.services.CustomerService;
import com.spiceUp.services.CustomerServiceImpl;

public class CustomerUI {

	static void customerRegistration(Scanner sc) {
		Print.printLine(1);
		Messages.takeInput("Enter username",null);
		String username = sc.next();
		Print.printLine(1);
		
		Messages.takeInput("Enter password", null);
		String password = sc.next();
		Print.printLine(1);
		
		Messages.takeInput("Enter email", null);
		String email = sc.next();
		Print.printLine(1);

		Customer cus = new Customer(username, password, email, new HashSet<>(), IsDeleted.NO);

		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.addCustomer(cus);
			Messages.success("Customer added successfully");
			Print.printLine(1);
		} catch (SomeThingWentWrongException ex) {
			Messages.error(ex.getMessage());
		}
	}

	public static void userLogin(Scanner sc) {
		Messages.takeInput("Enter username",null);
		String username = sc.next();
		Print.printLine(1);
		
		Messages.takeInput("Enter password",null);
		String password = sc.next();
		Print.printLine(1);
		
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			Messages.error(ex.getMessage());
			Print.printLine(1);
		}

	}

	static void filterByIngredients(Scanner sc) {
		Messages.takeInput("Enter the Ingredients",null);
		String ingredient = sc.next();
		Print.printLine(1);
		
		CustomerService cs = new CustomerServiceImpl();

		try {
			cs.filterByIngredients(ingredient);
		} catch (NoRecordFoundException | SomeThingWentWrongException e) {
			Messages.error(e.getMessage());
		}

	}

	static void addToLike(Scanner sc) {
		Messages.takeInput("Enter the recipe Id",null);
		int recipe_id = sc.nextInt();
		Print.printLine(1);
		
		CustomerService cs = new CustomerServiceImpl();

		try {
			cs.addToLike(recipe_id);
		} catch (NoRecordFoundException | SomeThingWentWrongException e) {
			Messages.error(e.getMessage());
			Print.printLine(1);
		}

	}

	static void viewAllLikeRecipe() {
		CustomerService cs = new CustomerServiceImpl();

		try {
			cs.viewAllLikeRecipe();
		} catch (NoRecordFoundException | SomeThingWentWrongException e) {
			Messages.error(e.getMessage());
			Print.printLine(1);
		}
	}

	static void deleteMyAccount() {
		CustomerService cs = new CustomerServiceImpl();

		try {
			cs.deleteMyAccount();
		} catch (SomeThingWentWrongException e) {
			Messages.error(e);
			Print.printLine(1);
		}

	}

	static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			Messages.userOption();
			Messages.optionInput();
			choice = sc.nextInt();
			Print.printLine(1);
			switch (choice) {
			case 1: {
				AdminUI.viewAllRecipe();
				break;
			}
			case 2: {
				filterByIngredients(sc);
				break;
			}
			case 3: {
				addToLike(sc);
				break;
			}
			case 4: {
				viewAllLikeRecipe();
				break;
			}
			case 5: {
				deleteMyAccount();
				break;
			}
			case 0: {
				LoggedInUserId.loggedInUserId = 0;
				Messages.selectedOption("Thanks for using the services");
				break;
			}
			default: {
				Messages.error("Invalid choice, Try again");
			}
			}
		} while (choice != 0);
	}

}
