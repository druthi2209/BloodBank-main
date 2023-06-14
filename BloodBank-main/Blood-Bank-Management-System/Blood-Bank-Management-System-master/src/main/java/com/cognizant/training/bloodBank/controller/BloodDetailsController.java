package com.cognizant.training.bloodBank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.bloodBank.exception.BloodDetailsNotFoundException;
import com.cognizant.training.bloodBank.model.BloodDetails;
import com.cognizant.training.bloodBank.service.BloodDetailsService;

@RestController
@RequestMapping("/")
public class BloodDetailsController {

	@Autowired
	BloodDetailsService bloodDetailsService;

	
	@PostMapping("/blood-details")
	public BloodDetails createBloodDetails(@Valid @RequestBody BloodDetails bd) {
		
		return bloodDetailsService.save(bd);
	}
	

	@GetMapping("/blood-details/{location}")
	public List<BloodDetails> getBloodBankByLocation(@PathVariable(value = "location") String location){
		return bloodDetailsService.getBloodBankByLocation(location);
	}
	
	@GetMapping("/blood-details")
	public List<BloodDetails> getAllBloodDetails() {
		System.out.println("getAll");
		return bloodDetailsService.findAll();
	}
	
	
	@DeleteMapping("/blood-details/{id}")
    public ResponseEntity<BloodDetails> deleteBloodDetails(@PathVariable(value = "id") Long bdId) {
        Optional<BloodDetails> bd = bloodDetailsService.findOne(bdId);
        if (!bd.isPresent()) {
            throw new BloodDetailsNotFoundException("BloodDetails not found with ID: " + bdId);
        }

        bloodDetailsService.delete(bd.get());

        return ResponseEntity.ok().build();
    }
	
	@PutMapping("/blood-details/")
    public ResponseEntity<BloodDetails> updateBloodDetails(@Valid @RequestBody BloodDetails bd) {
        Optional<BloodDetails> bdOld = bloodDetailsService.findOne(bd.getBlood_id());
        if (!bdOld.isPresent()) {
            throw new BloodDetailsNotFoundException("BloodDetails not found with ID: " + bd.getBlood_id());
        }
		bd.setBlood_id(bdOld.get().getBlood_id());
		
		bloodDetailsService.save(bd);
		 return ResponseEntity.ok().build();

	}
}
