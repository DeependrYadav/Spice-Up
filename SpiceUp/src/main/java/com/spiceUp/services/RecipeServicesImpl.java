package com.spiceUp.services;

import java.util.List;

import com.spiceUp.dao.RecipeDAO;
import com.spiceUp.dao.RecipeDAOImpl;
import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public class RecipeServicesImpl implements RecipeServices{

	@Override
	public void addRecipe(Recipe recipe) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		RecipeDAO rdao = new RecipeDAOImpl();
		rdao.addRecipe(recipe);
	}

	@Override
	public void viewAllRecipes() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RecipeDAO rdao = new RecipeDAOImpl();
		List<Recipe> list = rdao.viewAllRecipes();
		for(Recipe r : list) {
			System.out.println("Recipe Id = "+ r.getRecipe_id()+", Recipe name = " + r.getRecipe_name()+ ", Ingredients = "+ r.getIngredients()
			+", Preparation steps = "+ r.getPreparation_steps());
		}
	}

	@Override
	public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException {
		RecipeDAO rdao = new RecipeDAOImpl();
		rdao.updateRecipe(recipe);
	}
	
}
