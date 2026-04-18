package com.autonationUSA.AutonationUSA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Customer;

@Service
public class LoginService {

	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationManager am;
	
	public ResponseEntity<String> customerLogin(Customer c) {
		System.out.println(c);
		Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(Long.toString(c.getCustomer_id()), c.getPassword()));
		System.out.println("Authroity : "+auth.getAuthorities().toArray()[0].toString());
		if(auth.isAuthenticated() && auth.getAuthorities().toArray()[0].toString().equals("CUST"))
		{
			
			return new ResponseEntity<String>( jwtService.generateToken(Long.toString(c.getCustomer_id())) , HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error", HttpStatus.EXPECTATION_FAILED);
	}
}
