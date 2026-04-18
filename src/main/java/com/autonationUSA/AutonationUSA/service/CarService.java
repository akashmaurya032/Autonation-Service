package com.autonationUSA.AutonationUSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Car;
import com.autonationUSA.AutonationUSA.repo.CarRepo;

@Service
public class CarService {

	@Autowired
	CarRepo carRepo;
	
	public ResponseEntity<List<Car>> getAllCars() {
		return new ResponseEntity<List<Car>>(carRepo.findAll(), HttpStatus.OK); 
	}
	public ResponseEntity<Car> getCarById(Long id) {
		return new ResponseEntity<Car>(carRepo.findById(id).orElse(null), HttpStatus.OK); 
	}
	public ResponseEntity<String> saveCar(Car car) {
		carRepo.save(car);
		return new ResponseEntity<String>("Car saved successfully", HttpStatus.CREATED); 
	}
	public ResponseEntity<String> deleteCar(Long id) {
		Car c = getCarById(id).getBody();
		if(c==null)
			return new ResponseEntity<String>("Error : Car ID not found", HttpStatus.OK);
		carRepo.delete(c);
		return new ResponseEntity<String>("Car deleted successfully", HttpStatus.OK); 
	}
	
	public ResponseEntity<String> updateCar(Car c){
		Car tmpc = getCarById(c.getCar_id()).getBody();
		if(tmpc==null)
			return new ResponseEntity<String>("Error : Car ID not found", HttpStatus.OK);
		if(c.getMileage() != 0)
			tmpc.setMileage(c.getMileage());
		if(c.getPrice() != 0)
			tmpc.setPrice(c.getPrice());
		if(c.getOdometerReading() != 0)
			tmpc.setOdometerReading(c.getOdometerReading());
		
		carRepo.save(tmpc);
		return new ResponseEntity<String>("Car Updated successfully", HttpStatus.CREATED); 
	}
	
	public ResponseEntity<String> getComparisonResult(long cid1, long cid2){
		Car c1 = getCarById(cid1).getBody();
		if(c1==null)
			return new ResponseEntity<String>("card_id1 not found", HttpStatus.EXPECTATION_FAILED);
		Car c2 = getCarById(cid2).getBody();
		if(c2==null)
			return new ResponseEntity<String>("card_id2 not found", HttpStatus.EXPECTATION_FAILED);
		
		StringBuilder sb = new StringBuilder();
		sb.append("location - " + (c1.getLocation().equals(c2.getLocation())== true ? "Same" : c1.getLocation() + " : "+ c2.getLocation() ));
		sb.append("Manufacturer - " + (c1.getManufacturer().equals(c2.getManufacturer())== true ? "Same" : c1.getManufacturer() + " : "+ c2.getManufacturer() ));
		sb.append("Year - " + (c1.getYear() == c2.getYear() ? "Same" : c1.getYear() + " : "+ c2.getYear() ));
		sb.append("Model - " + (c1.getModel().equals(c2.getModel())== true ? "Same" : c1.getModel() + " : "+ c2.getModel() ));
		sb.append("Color - " + (c1.getColor().equals(c2.getColor())== true ? "Same" : c1.getColor() + " : "+ c2.getColor() ));
		sb.append("Price - " + (c1.getPrice()==c2.getPrice() ? "Same" : c1.getPrice() + " : "+ c2.getPrice() ));
		sb.append("Mileage - " + (c1.getMileage() == c2.getMileage() ? "Same" : c1.getMileage() + " : "+ c2.getMileage() ));
		sb.append("OdometerReading - " + (c1.getOdometerReading()==c2.getOdometerReading() ? "Same" : c1.getOdometerReading() + " : "+ c2.getOdometerReading() ));
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}
	

	public ResponseEntity<List<Car>> findByManufacturerAndPriceAndModelAndYearAndOdometerReading(String manufacturer, double price, String model, int year, int odometerReading){
		List<Car> cars=carRepo.findByManufacturerAndPriceAndModelAndYearAndOdometerReading(manufacturer, price, model, year, odometerReading);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	};
}
