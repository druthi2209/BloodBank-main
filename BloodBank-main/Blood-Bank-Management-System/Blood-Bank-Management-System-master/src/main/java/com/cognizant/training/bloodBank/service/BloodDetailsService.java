package com.cognizant.training.bloodBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.BloodDetails;

@Service
public interface BloodDetailsService {
	
	BloodDetails save(BloodDetails bd);
	
	void delete(BloodDetails bd);
	
	List<BloodDetails> findAll();
	
	Optional<BloodDetails> findOne(Long bdid);
	
	List<BloodDetails> getBloodBankByLocation(String location);
	

}
