package com.spiceUp.services;

import java.util.List;
import java.util.Map;

import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface RecipeServices {
	
	void addRecipe(Recipe recipe)throws SomeThingWentWrongException;
	
	List<Recipe> viewAllRecipes()throws SomeThingWentWrongException,NoRecordFoundException;
	
	void updateRecipe(Recipe recipe)throws SomeThingWentWrongException,NoRecordFoundException;
	
	void deleteRecipe(int recipe_id)throws SomeThingWentWrongException,NoRecordFoundException;
	
	Map<String , Integer> viewNumberOfLikes()throws SomeThingWentWrongException;
}
