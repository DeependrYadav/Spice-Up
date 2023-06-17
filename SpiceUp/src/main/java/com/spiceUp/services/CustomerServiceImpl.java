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
	public List<Recipe> filterByIngredients(String str) throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();		
		return cdao.filterByIngredients(str);
	}

	@Override
	public void addToLike(int recipe_id) throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.addToLike(recipe_id);
	}

	@Override
	public List<Recipe> viewAllLikeRecipe() throws NoRecordFoundException, SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		return cdao.viewAllLikeRecipe();
	}

	@Override
	public void deleteMyAccount() throws SomeThingWentWrongException {
		CustomerDAO cdao = new CustomerDAOImpl();
		cdao.deleteMyAccount();
	}

}
