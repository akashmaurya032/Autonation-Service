package com.autonationUSA.AutonationUSA.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Admin;
import com.autonationUSA.AutonationUSA.model.OTP;
import com.autonationUSA.AutonationUSA.repo.AdminRepo;
import com.autonationUSA.AutonationUSA.repo.OTPRepo;

@Service
public class OTPService {
	
	@Autowired
	OTPRepo otpRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public ResponseEntity<String> generateOTP(String email) {
	
		Admin admin = adminRepo.findById(email).orElse(null);
		if(admin == null)
			return new ResponseEntity<String>("No Admin : "+email + " found!", HttpStatus.EXPECTATION_FAILED);
		String otp=String.format("%06d", (int)(Math.random()* 1000000));
		OTP otpEntity = new OTP();
		otpEntity.setEmail(email);
		otpEntity.setOtp(otp);
		otpEntity.setExpirationTime(LocalDateTime.now().plusMinutes(5));
		otpRepo.save(otpEntity);
		sendOTP(email,otp);
		return new ResponseEntity<String>("OTP Sent to your email, Please verify it", HttpStatus.CREATED);
		
	}
	
	public void sendOTP(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Email");
		message.setText("Dear Admin : "+email+ " Your OTP is : " + otp);
		javaMailSender.send(message);
		
	}
	
	public ResponseEntity<String> verifyOTP(String email, String otp) {
		OTP otpEnt = otpRepo.findById(email).orElse(null);
		if(otpEnt==null)
			return new ResponseEntity<String>("No OTP generated yet!!", HttpStatus.EXPECTATION_FAILED);
		if(otpEnt.getExpirationTime().isBefore(LocalDateTime.now()))
			return new ResponseEntity<String>("OTP Expired, please generate new OTP", HttpStatus.EXPECTATION_FAILED);
		otpRepo.delete(otpEnt);
		return new ResponseEntity<String>("OTP Successfully Verified", HttpStatus.OK);
	}

}
