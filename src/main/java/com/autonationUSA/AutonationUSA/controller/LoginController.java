package com.autonationUSA.AutonationUSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autonationUSA.AutonationUSA.model.Customer;
import com.autonationUSA.AutonationUSA.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping("/customerLogin")
	public ResponseEntity<String> customerLogin(@RequestBody Customer c) {
		return loginService.customerLogin(c);
	}
}
