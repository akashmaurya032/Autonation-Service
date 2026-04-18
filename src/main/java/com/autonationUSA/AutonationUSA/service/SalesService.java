package com.autonationUSA.AutonationUSA.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Sale;
import com.autonationUSA.AutonationUSA.repo.SalesRepo;

@Service
public class SalesService {

	@Autowired
	SalesRepo salesRepo;
	
	public ResponseEntity<String> createSale(Sale s){
		salesRepo.save(s); 
		return new ResponseEntity<String>("Sale successfylly created", HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Sale>> getSalesReport(Date startDate, Date endDate){
		List<Sale> sales = salesRepo.findBySaleDateBetween(startDate, endDate);
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.OK); 
	}
	
	public ResponseEntity<Double> getTotalSaleAmount(Date startDate, Date endDate){
		List<Sale> sales = getSalesReport(startDate, endDate).getBody();
		double totalAmount = 0;
		
		for(Sale s : sales)
			totalAmount += s.getSalePrice();
			
		return new ResponseEntity<Double>(totalAmount, HttpStatus.OK); 
	}
}
