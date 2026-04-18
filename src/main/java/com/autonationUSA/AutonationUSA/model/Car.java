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
@Table(name = "Cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long car_id;
	private String location;
	private String manufacturer;
	private int year;
	private String model;
	private double price;
	private String color;
	private int mileage;
	private int odometerReading;
	
	@OneToMany(mappedBy = "car")
	@JsonBackReference(value = "sales_car")
	private List<Sale> sales;

	public long getCar_id() {
		return car_id;
	}

	public void setCar_id(long car_id) {
		this.car_id = car_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", location=" + location + ", manufacturer=" + manufacturer + ", year=" + year
				+ ", model=" + model + ", price=" + price + ", color=" + color + ", mileage=" + mileage
				+ ", odometerReading=" + odometerReading + "]";
	}
	
	
}
