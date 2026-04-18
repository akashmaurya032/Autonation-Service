package com.autonationUSA.AutonationUSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autonationUSA.AutonationUSA.model.User;
import com.autonationUSA.AutonationUSA.service.OTPService;

@RestController
@RequestMapping("/admin")
public class OTPController {
	@Autowired
	OTPService otpService;
	
	@PostMapping("/generateOTP")
	public ResponseEntity<String> generateOTP(@RequestParam String email) {
		System.out.println("Your email : "+email);
		return otpService.generateOTP(email);
	}
	
	@PostMapping("/verifyOTP")
	public ResponseEntity<String> verifyOTP(@RequestBody User user){
		return otpService.verifyOTP(user.getEmail(), user.getOtp());
	}

}
