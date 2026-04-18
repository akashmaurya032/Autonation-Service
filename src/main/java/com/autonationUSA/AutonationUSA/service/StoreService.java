package com.autonationUSA.AutonationUSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.autonationUSA.AutonationUSA.model.Store;

import com.autonationUSA.AutonationUSA.repo.StoreRepo;

@Service
public class StoreService {
	
	@Autowired
	StoreRepo storeRepo;

	public ResponseEntity<List<Store>> getAllStores() {
		return new ResponseEntity<List<Store>>(storeRepo.findAll(), HttpStatus.OK); 
	}
	public ResponseEntity<Store> getStoreById(Long id) {
		return new ResponseEntity<Store>(storeRepo.findById(id).orElse(null), HttpStatus.OK); 
	}
	public ResponseEntity<String> saveStore(Store store) {
		storeRepo.save(store);
		return new ResponseEntity<String>("Store saved successfully", HttpStatus.CREATED); 
	}
	public ResponseEntity<String> deleteStore(Long id) {
		Store s = getStoreById(id).getBody();
		if(s==null)
			return new ResponseEntity<String>("Error : Store ID not found", HttpStatus.OK);
		storeRepo.delete(s);
		return new ResponseEntity<String>("Store deleted successfully", HttpStatus.OK); 
	}

}
