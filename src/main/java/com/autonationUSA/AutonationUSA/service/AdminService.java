package com.autonationUSA.AutonationUSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Admin;
import com.autonationUSA.AutonationUSA.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;
	
	public ResponseEntity<List<Admin>> getAllAdmin() {
		return new ResponseEntity<List<Admin>>(adminRepo.findAll(), HttpStatus.OK); 
	}
	public ResponseEntity<Admin> getAdminByUsername(String username) {
		return new ResponseEntity<Admin>(adminRepo.findById(username).orElse(null), HttpStatus.OK); 
	}
	public ResponseEntity<String> saveAdmin(Admin admin) {
		adminRepo.save(admin);
		return new ResponseEntity<String>("Admin saved successfully", HttpStatus.CREATED); 
	}
	public ResponseEntity<String> deleteAdmin(String username) {
		Admin a = getAdminByUsername(username).getBody();
		if(a==null)
			return new ResponseEntity<String>("Error : Admin username not found", HttpStatus.OK);
		adminRepo.delete(a);
		return new ResponseEntity<String>("Admin deleted successfully", HttpStatus.OK); 
	}
	
	public ResponseEntity<String> updateAdmin(Admin a){
		Admin tmpa = getAdminByUsername(a.getUsername()).getBody();
		if(tmpa==null)
			return new ResponseEntity<String>("Error : Admin not found", HttpStatus.OK);
		if(a.getEmail() != null)
			tmpa.setEmail(a.getEmail());
		if(a.getRole() != null)
			tmpa.setRole(a.getRole());
		
		adminRepo.save(tmpa);
		return new ResponseEntity<String>("Admin Updated successfully", HttpStatus.CREATED); 
	}

}
