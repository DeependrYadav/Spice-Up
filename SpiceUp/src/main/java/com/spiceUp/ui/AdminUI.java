package com.spiceUp.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.spiceUp.entity.IsDeleted;
import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.javaFrame.Messages;
import com.spiceUp.javaFrame.Print;
import com.spiceUp.services.RecipeServices;
import com.spiceUp.services.RecipeServicesImpl;

public class AdminUI {

	static void addRecipe(Scanner sc) {
		Messages.takeInput("Enter the recipe name",null);
		sc.nextLine();
		String recipe_name = sc.nextLine();
		Print.printLine(1);
		
		Messages.takeInput("Enter the ingredients",null);
		String ingredients = sc.nextLine();
		Print.printLine(1);
		
		Messages.takeInput("Enter the preparation steps",null);
		String preparation_steps = sc.nextLine();
		Print.printLine(1);
		
		Recipe recipe = new Recipe(recipe_name, ingredients, preparation_steps, new HashSet<>(),IsDeleted.NO);
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
			List<Recipe> recipe = rs.viewAllRecipes();
			
			for(Recipe r : recipe) {
			System.out.println("Recipe Id = "+ r.getRecipe_id()+", Recipe name = " + r.getRecipe_name()+ ", Ingredients = "+ r.getIngredients()
			+", Preparation steps = "+ r.getPreparation_steps());
		}
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	static void updateRecipe(Scanner sc) {
		Messages.takeInput("Enter the recipe id",null);
		int id = sc.nextInt();
		Print.printLine(1);
		
		Messages.takeInput("Enter the recipe name",null);
		sc.nextLine();
		String recipe_name = sc.nextLine();
		Print.printLine(1);
		
		Messages.takeInput("Enter the ingredients",null);
		String ingredients = sc.nextLine();
		Print.printLine(1);
		
		Messages.takeInput("Enter the preparation steps",null);
		String preparation_steps = sc.nextLine();
		Print.printLine(1);
		Recipe recipe = new Recipe(recipe_name, ingredients, preparation_steps, new HashSet<>(),IsDeleted.NO);
		
		recipe.setRecipe_id(id);
		
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			rs.updateRecipe(recipe);
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteRecipe(Scanner sc) {
		Messages.takeInput("Enter the recipe id",null);
		int recipe_id = sc.nextInt();
		Print.printLine(1);
		
		RecipeServices rs = new RecipeServicesImpl();
		try {
			rs.deleteRecipe(recipe_id);
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}

	public static void viewNumberOfLike() {
		
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			Map<String , Integer> recipeMap = rs.viewNumberOfLikes();
			
			for(Map.Entry<String,Integer> m : recipeMap.entrySet()) {
				System.out.println("Recipe Name = "+m.getKey()+", Number of likes = "+m.getValue());
			}
			
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
