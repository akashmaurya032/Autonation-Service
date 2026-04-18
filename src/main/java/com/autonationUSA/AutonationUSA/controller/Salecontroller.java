package com.autonationUSA.AutonationUSA.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autonationUSA.AutonationUSA.model.Sale;
import com.autonationUSA.AutonationUSA.service.SalesService;

@RestController
@RequestMapping("/admin")
public class Salecontroller {
	
	@Autowired
	SalesService salesService;
	
	@PostMapping("/createSale")
	public ResponseEntity<String> createSale(@RequestBody Sale s){
		return salesService.createSale(s);
	}
	
	@GetMapping("/getSalesReport")
	public ResponseEntity<List<Sale>> getSalesReport(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
		return salesService.getSalesReport(startDate, endDate);
	}

	@GetMapping("/getTotalSaleAmount")
	public ResponseEntity<Double> getTotalSaleAmount(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
		return salesService.getTotalSaleAmount(startDate, endDate);
	}
}
