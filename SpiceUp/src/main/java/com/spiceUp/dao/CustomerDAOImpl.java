package com.spiceUp.dao;

import java.util.ArrayList;
import java.util.List;

import com.spiceUp.entity.Customer;
import com.spiceUp.entity.IsDeleted;
import com.spiceUp.entity.LoggedInUserId;
import com.spiceUp.entity.Recipe;
import com.spiceUp.exception.NoRecordFoundException;
import com.spiceUp.exception.SomeThingWentWrongException;
import com.spiceUp.javaFrame.Messages;
import com.spiceUp.javaFrame.Print;
import com.spiceUp.utility.EMUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO{
	static EntityManagerFactory emf = EMUtil.createEntityManager(); 
	@Override
	public void login(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException {// This function is checking user credentials
		try(EntityManager em = emf.createEntityManager()){
			String check = "SELECT c.customer_id FROM Customer c WHERE username = :username AND password = :password AND is_deleted = NO";
			Query q = em.createQuery(check);// Running query
			q.setParameter("username", username);// Putting username
			q.setParameter("password", password);// Putting user password
			List<Integer> list = q.getResultList();
			if(list.size() == 0) {
				throw new NoRecordFoundException("Wrong password");
			}
			LoggedInUserId.loggedInUserId = list.get(0);// Setting user Id for future requests
			
			Messages.success("Successfully login");
			Print.printLine(1);
			
		}catch(Exception ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
	}

	@Override
	public void addCustomer(Customer cus) throws SomeThingWentWrongException {// This function is registering the new customer 
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			String check = "SELECT COUNT(c) FROM Customer c WHERE username = :username";
			Query q = em.createQuery(check);// Checking username is already exist or not 
			q.setParameter("username", cus.getUsername());
			if((long)q.getSingleResult() > 0) {// If name is already exist
				throw new SomeThingWentWrongException("Customer with this username already exist");
			}
			et = em.getTransaction();
			
			et.begin();
			em.persist(cus);
			et.commit();
			
			Messages.success("Customer registered successfully");
			Print.printLine(1);
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to add customer");
		}finally {
			em.close();
		}
	}

	@Override
	public List<Recipe> filterByIngredients(String str) throws NoRecordFoundException, SomeThingWentWrongException {// This function will filter the recipe by ingredients
		List<Recipe> list = null;
		try(EntityManager em = emf.createEntityManager()){
			
			Query q = em.createQuery("SELECT r FROM Recipe r WHERE r.ingredients LIKE :like");//Running query
			
			q.setParameter("like", str);
			
			list = (List<Recipe>)q.getResultList();
			
			if(list.size() == 0)throw new NoRecordFoundException("No record Found");// If no record found 
			
		}catch(Exception ex) {// In case of any exception this block will execute
//			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
		return list;
	}

	@Override
	public void addToLike(int recipe_id) throws NoRecordFoundException, SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			
			Recipe recipeFromDB = em.find(Recipe.class, recipe_id);
			Customer customerFromDB = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			if(recipeFromDB == null || recipeFromDB.getIs_deleted() == IsDeleted.YES) {
				throw new NoRecordFoundException("No record found");
			}
			if(customerFromDB.getRecipe_Set().contains(recipeFromDB)) {
				throw new NoRecordFoundException("You already liked this recipe");
			}
			et = em.getTransaction();
			et.begin();
			customerFromDB.getRecipe_Set().add(recipeFromDB);
			recipeFromDB.getCustomer_set().add(customerFromDB);
			et.commit();
			
			Messages.success("Added to like successfully");
			Print.printLine(1);
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Recipe> viewAllLikeRecipe() throws NoRecordFoundException, SomeThingWentWrongException {
		List<Recipe> list = new ArrayList<>();
		
		try (EntityManager em = emf.createEntityManager();){
			
			Customer customerFromDB = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			if(customerFromDB.getRecipe_Set().size() == 0) {
				throw new NoRecordFoundException("You Haven't liked any recipe");
			}
//			System.out.println(customerFromDB.getRecipe_Set());
			for(Recipe r : customerFromDB.getRecipe_Set())list.add(r);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
		
		return list;
	}

	@Override
	public void deleteMyAccount() throws SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			
			Query q = em.createNativeQuery("DELETE FROM like_table WHERE customer_set_customer_id = :cusId");
			q.setParameter("cusId", LoggedInUserId.loggedInUserId);
			
			Customer customerFromDB = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			
			et = em.getTransaction();
			et.begin();
//			customerFromDB.setRecipe_Set(null);
			customerFromDB.setIs_deleted(IsDeleted.YES);
			q.executeUpdate();
			et.commit();
			
			Messages.success("Account deleted successfully");
			Print.printLine(1);
			
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

}
