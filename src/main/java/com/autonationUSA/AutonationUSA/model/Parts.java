package com.autonationUSA.AutonationUSA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parts")
public class Parts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long part_id;
	private String name;
	private String description;
	private String fits;
	private double price;
	private int quantity;


	public long getPart_id() {
		return part_id;
	}


	public void setPart_id(long part_id) {
		this.part_id = part_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFits() {
		return fits;
	}


	public void setFits(String fits) {
		this.fits = fits;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Parts [part_id=" + part_id + ", name=" + name + ", description=" + description + ", fits=" + fits
				+ ", price=" + price + ", quantity=" + quantity + "]";
	} 
	
	
	
}
