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
			Messages.error(e.getMessage());
		}
	}
	
	static void viewAllRecipe() {
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			List<Recipe> recipe = rs.viewAllRecipes();
			
			recipe.forEach(r->{
				Messages.valueName("Recipe Id = ");
				Messages.value(r.getRecipe_id());
				Messages.valueName(", Recipe name = ");
				Messages.value(r.getRecipe_name());
				Messages.valueName(", Ingredients = ");
				Messages.value(r.getIngredients());
				Messages.valueName(", Preparation steps = ");
				Messages.value(r.getPreparation_steps());
				Print.printLine(1);
			});
			Print.printLine(1);
		} catch (SomeThingWentWrongException | NoRecordFoundException e) {
			Messages.error(e.getMessage());
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
			Messages.error(e.getMessage());
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
			Messages.error(e.getMessage());
		}
	}

	public static void viewNumberOfLike() {
		
		RecipeServices rs = new RecipeServicesImpl();
		
		try {
			Map<String , Integer> recipeMap = rs.viewNumberOfLikes();
			
			recipeMap.forEach((k,v)->{
				Messages.valueName("Recipe Name = ");
				Messages.value(k);
				Messages.valueName(", Number of likes = ");
				Messages.value(v);
				Print.printLine(1);
			});
			Print.printLine(1);
			
		} catch (SomeThingWentWrongException e) {
			Messages.error(e.getMessage());
		}
	}
	
}
