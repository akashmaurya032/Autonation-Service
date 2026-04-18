package com.autonationUSA.AutonationUSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.autonationUSA.AutonationUSA.model.Customer;
import com.autonationUSA.AutonationUSA.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepository;

	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK); 
	}
	public ResponseEntity<Customer> getCustomerById(Long id) {
		return new ResponseEntity<Customer>(customerRepository.findById(id).orElse(null), HttpStatus.OK); 
	}
	public ResponseEntity<String> saveCustomer(Customer customer) {
		customer.setPassword(new BCryptPasswordEncoder(12).encode(customer.getPassword()));
		customerRepository.save(customer);
		return new ResponseEntity<String>("Customer saved successfully", HttpStatus.CREATED); 
	}
	public ResponseEntity<String> deleteCustomer(Long id) {
		Customer c = getCustomerById(id).getBody();
		if(c==null)
			return new ResponseEntity<String>("Error : customer ID not found", HttpStatus.OK);
		customerRepository.delete(c);
		return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.OK); 
	}
	
	public ResponseEntity<String> updateCustomer(Customer c){
		Customer tmpc = getCustomerById(c.getCustomer_id()).getBody();
		if(tmpc==null)
			return new ResponseEntity<String>("Error : customer ID not found", HttpStatus.OK);
		if(c.getEmail() != null)
			tmpc.setEmail(c.getEmail());
		if(c.getPhone() != null)
			tmpc.setPhone(c.getPhone());
		
		customerRepository.save(tmpc);
		return new ResponseEntity<String>("Customer Updated successfully", HttpStatus.CREATED); 
	}
	

}
