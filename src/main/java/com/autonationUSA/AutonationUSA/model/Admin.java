package com.autonationUSA.AutonationUSA.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	private String username;
	private String email;
	private String role;//Roles for Users
	@OneToMany(mappedBy = "admin")
	@JsonBackReference(value = "sales_admin")
	private List<Sale> sales;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", email=" + email + ", role=" + role + "]";
	}
	


	
	
	
}
