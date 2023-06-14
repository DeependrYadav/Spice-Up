package com.spiceUp.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipe_id;
	@Column(nullable = false)
	private String recipe_name;
	@Column(nullable = false)
	private String ingredients;
	@Column(nullable = false)
	private String preparation_steps;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "like_table", 
				joinColumns = {@JoinColumn(referencedColumnName = "recipe_id") }, 
				inverseJoinColumns = {@JoinColumn(referencedColumnName = "customer_id") })
	Set<Customer> customer_set;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(String recipe_name, String ingredients, String preparation_steps, Set<Customer> customer_set) {
		super();
		this.recipe_name = recipe_name;
		this.ingredients = ingredients;
		this.preparation_steps = preparation_steps;
		this.customer_set = customer_set;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreparation_steps() {
		return preparation_steps;
	}

	public void setPreparation_steps(String preparation_steps) {
		this.preparation_steps = preparation_steps;
	}

	public Set<Customer> getCustomer_set() {
		return customer_set;
	}

	public void setCustomer_set(Set<Customer> customer_set) {
		this.customer_set = customer_set;
	}

}
