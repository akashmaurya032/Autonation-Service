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

import com.autonationUSA.AutonationUSA.model.Admin;

import com.autonationUSA.AutonationUSA.service.AdminService;
import com.autonationUSA.AutonationUSA.service.OTPService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/getAdminByUsername")
	public ResponseEntity<Admin> getAdminByUsername(@RequestParam String username) {
		return adminService.getAdminByUsername(username);
	}
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin a){
		return adminService.updateAdmin(a);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteAdmin(@RequestParam String username) {
		return adminService.deleteAdmin(username);
	}
}
