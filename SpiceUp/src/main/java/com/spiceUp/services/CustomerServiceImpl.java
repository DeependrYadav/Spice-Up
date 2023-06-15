package com.spiceUp.services;

import java.util.List;

import com.spiceUp.dao.CustomerDAO;
import com.spiceUp.dao.CustomerDAOImpl;
import com.spiceUp.entity.Customer;
import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void login(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.login(username, password);
	}

	@Override
	public void addCustomer(Customer cus) throws SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.addCustomer(cus);
	}

	@Override
	public void filterByIngredients(String str) throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		
		List<Recipe> list = cdao.filterByIngredients(str);

		for(Recipe r : list) {
			System.out.println("Recipe Id = "+ r.getRecipe_id()+", Recipe name = " + r.getRecipe_name()+ ", Ingredients = "+ r.getIngredients()
			+", Preparation steps = "+ r.getPreparation_steps());
		}
	}

	@Override
	public void addToLike(int recipe_id) throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.addToLike(recipe_id);
	}

	@Override
	public void viewAllLikeRecipe() throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		
		List<Recipe> list = cdao.viewAllLikeRecipe();
		
		for(Recipe r : list) {
			System.out.println("Recipe Id = "+ r.getRecipe_id()+", Recipe name = " + r.getRecipe_name()+ ", Ingredients = "+ r.getIngredients()
			+", Preparation steps = "+ r.getPreparation_steps());
		}
	}

	@Override
	public void deleteMyAccount() throws SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.deleteMyAccount();
	}

}
