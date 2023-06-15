package com.spiceUp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Recipe> viewAllRecipes() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RecipeDAO rdao = new RecipeDAOImpl();
		return rdao.viewAllRecipes();
		
	}

	@Override
	public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException {
		RecipeDAO rdao = new RecipeDAOImpl();
		rdao.updateRecipe(recipe);
	}

	@Override
	public void deleteRecipe(int recipe_id) throws SomeThingWentWrongException, NoRecordFoundException {
		RecipeDAO rdao = new RecipeDAOImpl();
		rdao.deleteRecipe(recipe_id);
	}

	@Override
	public Map<String , Integer> viewNumberOfLikes() throws SomeThingWentWrongException {
		RecipeDAO rdao = new RecipeDAOImpl();
		List<Recipe> list = rdao.viewNumberOfLikes();
		Map<String , Integer> recipeMap = new HashMap<>();
		
		list.stream().forEach(r->recipeMap.put(r.getRecipe_name(), r.getCustomer_set().size()));
		
		return recipeMap;
		
	}
	
}
