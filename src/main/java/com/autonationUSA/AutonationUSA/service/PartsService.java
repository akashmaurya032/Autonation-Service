package com.autonationUSA.AutonationUSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.autonationUSA.AutonationUSA.model.Parts;
import com.autonationUSA.AutonationUSA.repo.PartsRepo;

@Service
public class PartsService {

	@Autowired
	PartsRepo partsRepo;
	
	public ResponseEntity<List<Parts>> getAllParts(){
		return new ResponseEntity<List<Parts>>(partsRepo.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<Parts> getPartsById(long part_id){
		Parts parts = partsRepo.findById(part_id).orElse(null);
		return new ResponseEntity<Parts>(parts, HttpStatus.OK);
	}
	
	 public ResponseEntity<String> savePart(Parts part) {
		 partsRepo.save(part);
		 return new ResponseEntity<String>("Parts data saved successfully", HttpStatus.CREATED);
		 }
	 
	 public ResponseEntity<String> updatePart(Parts part) {
		 System.out.println(part);
		 Parts tmppart = getPartsById(part.getPart_id()).getBody();
		 if(tmppart == null)
			 return new ResponseEntity<String>("Some Error : Part ID not found", HttpStatus.EXPECTATION_FAILED);
		 
		 if(part.getPrice() != 0)
			 tmppart.setPrice(part.getPrice());
		 if(part.getQuantity() != 0)
			 tmppart.setQuantity(part.getQuantity());
		 
		 partsRepo.save(tmppart);
		 return new ResponseEntity<String>("Parts data updated successfully", HttpStatus.CREATED);
		 }
	 
	 public ResponseEntity<String> deletePart(long part_id) {
		 Parts tmppart = getPartsById(part_id).getBody();
		 if(tmppart == null)
			 return new ResponseEntity<String>("Some Error : Part ID not found", HttpStatus.EXPECTATION_FAILED);
		 
		 partsRepo.delete(tmppart);
		 return new ResponseEntity<String>("Parts data deleted successfully", HttpStatus.OK);
		 }
	 
	 public Parts buy(long part_id) {
		 Parts part=getPartsById(part_id).getBody();
		 return part;
	 }

	 


}
