package com.spiceUp.services;

import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface RecipeServices {
	void addRecipe(Recipe recipe)throws SomeThingWentWrongException;
	void viewAllRecipes()throws SomeThingWentWrongException,NoRecordFoundException;
	void updateRecipe(Recipe recipe)throws SomeThingWentWrongException,NoRecordFoundException;
}
