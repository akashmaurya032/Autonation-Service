package com.autonationUSA.AutonationUSA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Customer;
import com.autonationUSA.AutonationUSA.model.UserDetailsCustomer;
import com.autonationUSA.AutonationUSA.repo.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	CustomerService customerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer c = customerService.getCustomerById(Long.parseLong(username)).getBody();
		System.out.println(c);
		if(c != null)
			return new UserDetailsCustomer(c);
		
		throw new UsernameNotFoundException(username+" : Customer not found");
	}

	
}
