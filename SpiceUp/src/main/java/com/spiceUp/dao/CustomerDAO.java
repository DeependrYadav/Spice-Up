package com.spiceUp.dao;

import com.spiceUp.entity.Customer;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;

public interface CustomerDAO {
	void login(String username, String password) throws NoRecordFoundException,SomeThingWentWrongException;

	void addCustomer(Customer cus)throws SomeThingWentWrongException;
}
