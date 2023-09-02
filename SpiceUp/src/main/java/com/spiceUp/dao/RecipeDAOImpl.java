package com.spiceUp.dao;

import java.util.List;

import com.spiceUp.entity.IsDeleted;
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

public class RecipeDAOImpl implements RecipeDAO {
	static EntityManagerFactory emf = EMUtil.createEntityManager();
	@Override
	public void addRecipe(Recipe recipe) throws SomeThingWentWrongException { // This function will add the recipe to database
		EntityManager em = null; 
		EntityTransaction et = null;
		try {
			String findQuery = "SELECT COUNT(r) FROM Recipe r WHERE r.recipe_name = :rn AND r.is_deleted = NO";
			em = emf.createEntityManager(); // creating EntityManager
			Query query = em.createQuery(findQuery);// Running query for checking recipe name already exist or not
			query.setParameter("rn", recipe.getRecipe_name());// setting parameter
			
			if((long)query.getSingleResult() > 0) {// if recipe name already exist then throwing exception
				throw new SomeThingWentWrongException("Recipe already exists with name " + recipe.getRecipe_name());
			}
			
			et = em.getTransaction();
			
			et.begin();
			em.persist(recipe);
			et.commit();
			
			Messages.success("Recipe added successfully");// Printing message by the help of JavaFrame package that I created in this project 
			Print.printLine(1);
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Recipe> viewAllRecipes() throws SomeThingWentWrongException,NoRecordFoundException {// This function will show us all recipe 
		List<Recipe> list = null;
		try(EntityManager em = emf.createEntityManager()){
			Query q = em.createQuery("SELECT r FROM Recipe r WHERE r.is_deleted = NO");
			
			list = (List<Recipe>)q.getResultList();
			
			if(list.size() == 0)throw new NoRecordFoundException("No company Found");// if Recipe list is 0 then throwing a exception
			
		}catch(Exception ex) {
//			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
		return list;
	}
	
	@Override
	public void updateRecipe(Recipe recipe) throws SomeThingWentWrongException, NoRecordFoundException {// This function will update the recipe
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			
			Recipe recipeFromDB = em.find(Recipe.class, recipe.getRecipe_id());// Finding the recipe by it's ID
			
			if(recipeFromDB == null) {// If recipe not found 
				throw new NoRecordFoundException("No record found");
			}
			// Updating recipe
			et = em.getTransaction();
			et.begin();
			recipeFromDB.setIngredients(recipe.getIngredients());
			recipeFromDB.setPreparation_steps(recipe.getPreparation_steps());
			recipeFromDB.setRecipe_name(recipe.getRecipe_name());
			et.commit();
			
			Messages.success("Recipe updated successfully");
			Print.printLine(1);
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteRecipe(int recipe_id) throws SomeThingWentWrongException, NoRecordFoundException {// This function will delete recipe It perform soft delete 
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			
			Recipe recipeFromDB = em.find(Recipe.class, recipe_id); // Finding recipe
			
			if(recipeFromDB == null) {
				throw new NoRecordFoundException("No record found");
			}
			et = em.getTransaction();
			et.begin();
			recipeFromDB.setIs_deleted(IsDeleted.YES);// Making value of is_deleted true
			et.commit();
			
			Messages.success("Recipe deleted successfully");
			Print.printLine(1);
			
		} catch (Exception e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Recipe> viewNumberOfLikes() throws SomeThingWentWrongException {
		List<Recipe> list = null;
		
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("SELECT r FROM Recipe r");
			
			list = (List<Recipe>)q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		return list;
	}
}
