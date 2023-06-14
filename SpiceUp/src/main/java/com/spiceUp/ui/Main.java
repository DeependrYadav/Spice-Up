package com.spiceUp.ui;

import java.util.Scanner;

public class Main {
	static void displayAdminMenu() {
		System.out.println("1. Add new recipes");
		System.out.println("2. View All recipes");
		System.out.println("3. Update existing recipes");
		System.out.println("4. Delete recipes");
		System.out.println("5. View the number of likes received by each recipe");
		System.out.println("6. Generate reports on recipe likes and popularity");
		System.out.println("0. Logout");
	}
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				AdminUI.addRecipe(sc);
				break;
			}
			case 2:{
				AdminUI.viewAllRecipe();
				break;
			}
			case 3:{
				AdminUI.updateRecipe(sc);
				break;
			}
			case 4:{
				
				break;
			}
			case 5:{
				
				break;
			}
			case 6:{
				
				break;
			}
			case 0:{
				System.out.println("Thanks for using the services");
				break;
			}
			default:System.out.println("Invalid section, Try again");
			}
		}while(choice != 0);
	}
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("a") && password.equals("a")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection : ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
	}
}
