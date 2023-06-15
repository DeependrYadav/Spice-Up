package com.spiceUp.services;

import com.spiceUp.entity.Customer;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface CustomerService {

	void login(String username, String password) throws NoRecordFoundException,SomeThingWentWrongException;

	void addCustomer(Customer cus)throws SomeThingWentWrongException;
	
	void filterByIngredients(String str)throws NoRecordFoundException,SomeThingWentWrongException;

	void addToLike(int recipe_id)throws NoRecordFoundException,SomeThingWentWrongException;

	void viewAllLikeRecipe()throws NoRecordFoundException,SomeThingWentWrongException;
	
	void deleteMyAccount()throws SomeThingWentWrongException;
}
