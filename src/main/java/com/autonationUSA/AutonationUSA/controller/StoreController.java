package com.autonationUSA.AutonationUSA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.autonationUSA.AutonationUSA.model.Store;
import com.autonationUSA.AutonationUSA.service.StoreService;

@RestController
@RequestMapping("/admin")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping("/getAllStores")
	public ResponseEntity<List<Store>> getAllStores() {
		return storeService.getAllStores();
	}
	
	@GetMapping("/getStoreById")
	public ResponseEntity<Store> getStoreById(@RequestParam Long id) {
		return storeService.getStoreById(id);
	}
	
	@PostMapping("/saveStore")
	public ResponseEntity<String> saveStore(@RequestBody Store store) {
		return storeService.saveStore(store);
	}
	
	@DeleteMapping("/deleteStore")
	public ResponseEntity<String> deleteStore(@RequestParam Long id) {
		return storeService.deleteStore(id);
	}
}
