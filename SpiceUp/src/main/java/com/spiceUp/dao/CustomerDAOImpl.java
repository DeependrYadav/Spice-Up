package com.spiceUp.dao;

import java.util.List;

import com.spiceUp.entity.Customer;
import com.spiceUp.entity.LoggedInUserId;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.utility.EMUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO{
	static EntityManagerFactory emf = EMUtil.createEntityManager(); 
	@Override
	public void login(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException {
		try(EntityManager em = emf.createEntityManager()){
			String check = "SELECT c.customer_id FROM Customer c WHERE username = :username AND password = :password";
			Query q = em.createQuery(check);
			q.setParameter("username", username);
			q.setParameter("password", password);
			List<Integer> list = (List<Integer>)q.getResultList();
			if(list.size() == 0) {
				throw new NoRecordFoundException("Wrong password");
			}
			LoggedInUserId.loggedInUserId = list.get(0);
//			System.out.println("login successfull");
		}catch(Exception ex) {
			throw new SomeThingWentWrongException("Error 404");
		}
	}

	@Override
	public void addCustomer(Customer cus) throws SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			String check = "SELECT COUNT(c) FROM Customer c WHERE username = :username";
			Query q = em.createQuery(check);
			q.setParameter("username", cus.getUsername());
			if((long)q.getSingleResult() > 0) {
				throw new SomeThingWentWrongException("Customer with this username already exist");
			}
			et = em.getTransaction();
			
			et.begin();
			em.persist(cus);
			et.commit();
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to add customer");
		}finally {
			em.close();
		}
	}

}
