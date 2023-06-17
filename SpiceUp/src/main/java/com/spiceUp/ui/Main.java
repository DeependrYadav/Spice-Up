package com.spiceUp.ui;

import java.util.Scanner;

import com.spiceUp.javaFrame.Messages;
import com.spiceUp.javaFrame.Print;

public class Main {

	static void adminMenu(Scanner sc) {
		Print.printLine(1);
		int choice = 0;
		do {
			try {
				do {
					Messages.adminOption();
					Messages.optionInput();
					choice = sc.nextInt();
					switch (choice) {
					case 1: {
						AdminUI.addRecipe(sc);
						break;
					}
					case 2: {
						AdminUI.viewAllRecipe();
						break;
					}
					case 3: {
						AdminUI.updateRecipe(sc);
						break;
					}
					case 4: {
						AdminUI.deleteRecipe(sc);
						break;
					}
					case 5: {
						AdminUI.viewNumberOfLike();
						break;
					}
					case 6: {

						break;
					}
					case 0: {
						Messages.success("Thanks for using the services");
						break;
					}
					default: {
						Print.printLine(1);
						Messages.error("Invalid section, Try again");
						Print.printLine(1);
					}
					}
				} while (choice != 0);
			} catch (Exception ex) {
//				ex.printStackTrace();
				sc.nextLine();
				Messages.warning("Please don't pass any other parameter");
				Print.printLine(1);
			}
			choice = 1;
		} while (choice != 0);
	}

	static void adminLogin(Scanner sc) {
		Messages.takeInput("Enter username", null);
		String username = sc.next();
		Print.printLine(1);
		Messages.takeInput("Enter password", null);
		String password = sc.next();
		Print.printLine(1);
		if (username.equals("a") && password.equals("a")) {
			adminMenu(sc);
		} else {
			Messages.error("Invalid Username of Password");
			Print.printLine(1);

		}
	}

	public static void main(String[] args) {
		Messages.initial();
		Messages.welcome();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				do {
					Messages.welcomeOption();
					Messages.optionInput();
					choice = sc.nextInt();
					Print.printLine(1);
					switch (choice) {
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
						Messages.selectedOption("Thanks for using the services");
						break;
					default:
						Messages.error("Invalid Selection, try again");
						Print.printLine(1);
					}

				} while (choice != 0);

			} catch (Exception ex) {
//				ex.printStackTrace();
				sc.nextLine();
				Print.printLine(1);
				Messages.warning("Please don't pass any other parameter");
				Print.printLine(1);
			}
			choice = 1;
		} while (choice != 0);
		sc.close();
	}
}
