package com.spiceUp.services;

import com.spiceUp.dao.CustomerDAO;
import com.spiceUp.dao.CustomerDAOImpl;
import com.spiceUp.entity.Customer;
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

}
