package com.autonationUSA.AutonationUSA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autonationUSA.AutonationUSA.model.Parts;
import com.autonationUSA.AutonationUSA.service.PartsService;

@Controller
public class PartsController {
	
	@Autowired
	PartsService partsService;
	
	@GetMapping("/customer/getAllParts")
	@ResponseBody
	public ResponseEntity<List<Parts>> getAllParts(){
		return partsService.getAllParts();
	}
	
	@GetMapping("/customer/getPartsById")
	@ResponseBody
	public ResponseEntity<Parts> getPartsById(@RequestParam long part_id){
		return partsService.getPartsById(part_id);
		
	}
	
	@PostMapping("/admin/savePart")
	@ResponseBody
	public ResponseEntity<String> savePart(@RequestBody Parts part) {
		return partsService.savePart(part);
	}
	
	@PutMapping("/admin/updatePart")
	@ResponseBody
	public ResponseEntity<String> updatePart(@RequestBody Parts part) {
		return partsService.updatePart(part);
	}

	@DeleteMapping("/admin/deletePart")
	@ResponseBody
	public ResponseEntity<String> deletePart(@RequestBody long part_id) {
		return partsService.deletePart(part_id);
	}
	
	@GetMapping("/customer/buy")
	public String buy(@RequestParam long part_id, Model model) {
		Parts part = partsService.buy(part_id);
		if(part == null)
			return "Error";
		model.addAttribute("amount", part.getPrice());
		return "payment";
	}
}
