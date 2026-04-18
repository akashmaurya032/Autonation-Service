package com.autonationUSA.AutonationUSA.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stores")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long store_id;
	private String name;
	private String location;
	private String manager;
	
	@OneToMany(mappedBy = "store")
	@JsonBackReference(value = "sales_store")
	private List<Sale> sales;

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", name=" + name + ", location=" + location + ", manager=" + manager
				+ "]";
	}
	
	
	

}
