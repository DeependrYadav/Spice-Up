package com.spiceUp.entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	
	@ManyToMany(mappedBy = "customer_set",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Recipe> recipe_Set;

	@Column(nullable = false)
	@Enumerated
	private IsDeleted is_deleted;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String email, Set<Recipe> recipe_Set,IsDeleted is_deleted) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.recipe_Set = recipe_Set;
		this.is_deleted = is_deleted;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Recipe> getRecipe_Set() {
		return recipe_Set;
	}

	public void setRecipe_Set(Set<Recipe> recipe_Set) {
		this.recipe_Set = recipe_Set;
	}

	public IsDeleted getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(IsDeleted is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_id, email, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customer_id == other.customer_id && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
}
