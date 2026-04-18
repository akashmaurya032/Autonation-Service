package com.autonationUSA.AutonationUSA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autonationUSA.AutonationUSA.model.Car;
import com.autonationUSA.AutonationUSA.model.CarFilter;
import com.autonationUSA.AutonationUSA.model.CarUser;
import com.autonationUSA.AutonationUSA.service.CarService;


@RestController
public class CarController {

	@Autowired
	CarService carService;
	
	@GetMapping("/customer/getAllCars")
	public ResponseEntity<List<Car>> getAllCars() {
		return carService.getAllCars();
	}
	
	@GetMapping("/customer/getCarById")
	public ResponseEntity<Car> getCarById(@RequestParam Long id) {
		return carService.getCarById(id);
	}
	
	@PostMapping("/admin/saveCar")
	public ResponseEntity<String> saveCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}
	
	@PutMapping("/admin/updateCar")
	public ResponseEntity<String> updateCar(@RequestBody Car c){
		return carService.updateCar(c);
	}
	
	@DeleteMapping("/admin/deleteCar")
	public ResponseEntity<String> deleteCar(@RequestParam Long id) {
		return carService.deleteCar(id);
	}
	
	@GetMapping("/customer/getComparisonResult")
	public ResponseEntity<String> getComparisonResult(@RequestBody CarUser user){
		return carService.getComparisonResult(user.getCar_id1(), user.getCar_id2());
	}
	
	@GetMapping("/customer/getCarsByFilter")
	public ResponseEntity<List<Car>> findByManufacturerAndPriceAndModelAndYearAndOdometerReading(@RequestBody CarFilter carFilter){
		return carService.findByManufacturerAndPriceAndModelAndYearAndOdometerReading(carFilter.getManufacturer(), carFilter.getPrice(), carFilter.getModel(), carFilter.getYear(), carFilter.getOdometeReading());
	}
}
