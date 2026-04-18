package com.autonationUSA.AutonationUSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autonationUSA.AutonationUSA.model.PayementUser;
import com.autonationUSA.AutonationUSA.service.PaymentService;



@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/createOrder")
	public ResponseEntity<Object> createOrder(@RequestBody PayementUser user){
		Object order = paymentService.createOrder(user.getAmount(), user.getCurrency(), user.getReceipt());
		return new ResponseEntity<Object>(order, HttpStatus.CREATED);
	}
}
