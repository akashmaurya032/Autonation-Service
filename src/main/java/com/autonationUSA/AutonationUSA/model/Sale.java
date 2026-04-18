package com.autonationUSA.AutonationUSA.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sale_id;
	private Date saleDate;
	private double salePrice;
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
	@ManyToOne
	@JoinColumn(name = "username")
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	public long getSale_id() {
		return sale_id;
	}
	public void setSale_id(long sale_id) {
		this.sale_id = sale_id;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "Sale [sale_id=" + sale_id + ", saleDate=" + saleDate + ", salePrice=" + salePrice + "]";
	}
	
	

}
