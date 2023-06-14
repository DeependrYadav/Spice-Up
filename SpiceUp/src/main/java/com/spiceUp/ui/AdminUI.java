package com.spiceUp.ui;

import java.util.HashSet;
import java.util.Scanner;

import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.services.RecipeServices;
import com.spiceUp.services.RecipeServicesImpl;

public class AdminUI {

	static void addRecipe(Scanner sc) {
		System.out.print("Enter the recipe name : ");
		sc.nextLine();
		String recipe_name = sc.nextLine();
		System.out.print("Enter the ingredients : ");
		String ingredients = sc.nextLine();
		System.out.print("Enter the preparation steps : ");
		String preparation_steps = sc.nextLine();
		
		Recipe recipe = new Recipe(recipe_name, ingredients, preparation_steps, new HashSet<>());
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			rs.addRecipe(recipe);
		} catch (SomeThingWentWrongException e) {
			e.printStackTrace();
		}
	}
	
	static void viewAllRecipe() {
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			rs.viewAllRecipes();
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void updateRecipe(Scanner sc) {
		System.out.print("Enter the recipe id : ");
		int id = sc.nextInt();
		System.out.print("Enter the recipe name : ");
		sc.nextLine();
		String recipe_name = sc.nextLine();
		System.out.print("Enter the ingredients : ");
		String ingredients = sc.nextLine();
		System.out.print("Enter the preparation steps : ");
		String preparation_steps = sc.nextLine();
		Recipe recipe = new Recipe(recipe_name, ingredients, preparation_steps, new HashSet<>());
		
		recipe.setRecipe_id(id);
		
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			rs.updateRecipe(recipe);
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}
	
}
