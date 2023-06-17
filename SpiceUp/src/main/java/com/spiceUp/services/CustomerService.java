package com.spiceUp.services;

import java.util.List;

import com.spiceUp.entity.Customer;
import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface CustomerService {

	void login(String username, String password) throws NoRecordFoundException,SomeThingWentWrongException;

	void addCustomer(Customer cus)throws SomeThingWentWrongException;
	
	List<Recipe> filterByIngredients(String str)throws NoRecordFoundException,SomeThingWentWrongException;

	void addToLike(int recipe_id)throws NoRecordFoundException,SomeThingWentWrongException;

	List<Recipe> viewAllLikeRecipe()throws NoRecordFoundException,SomeThingWentWrongException;
	
	void deleteMyAccount()throws SomeThingWentWrongException;
}
