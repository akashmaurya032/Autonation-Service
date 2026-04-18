package com.autonationUSA.AutonationUSA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autonationUSA.AutonationUSA.model.Customer;
import com.autonationUSA.AutonationUSA.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomerById")
	public ResponseEntity<Customer> getCustomerById(@RequestParam Long id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c){
		return customerService.updateCustomer(c);
	}
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {
		return customerService.deleteCustomer(id);
	}
	

}
