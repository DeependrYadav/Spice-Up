package com.spiceUp.dao;

import java.util.List;

import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface RecipeDAO {
	
	void addRecipe(Recipe recipe)throws SomeThingWentWrongException;
	
	List<Recipe> viewAllRecipes()throws SomeThingWentWrongException,NoRecordFoundException;
	
	void updateRecipe(Recipe recipe)throws SomeThingWentWrongException,NoRecordFoundException;
	
	void deleteRecipe(int recipe_id)throws SomeThingWentWrongException,NoRecordFoundException;
	
	List<Recipe> viewNumberOfLikes()throws SomeThingWentWrongException;
}