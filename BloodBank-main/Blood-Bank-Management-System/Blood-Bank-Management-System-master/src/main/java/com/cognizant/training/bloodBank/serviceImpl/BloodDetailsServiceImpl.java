package com.cognizant.training.bloodBank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.model.BloodDetails;
import com.cognizant.training.bloodBank.repository.BloodBankRepository;
import com.cognizant.training.bloodBank.repository.BloodDetailsRepository;
import com.cognizant.training.bloodBank.service.BloodDetailsService;

@Service
public class BloodDetailsServiceImpl implements BloodDetailsService{

	@Autowired
	BloodDetailsRepository bloodDetailsRepository;
	
	@Autowired
	BloodBankRepository bloodBankRepository;
	
	 @Override
	 public BloodDetails save(BloodDetails bd) {
	
		Optional<BloodDetails> bloodDetails = bloodDetailsRepository.findByBloodGroupAndBloodBankBloodBankId(bd.getBloodGroup(), bd.getBloodBank().getBloodBankId());
		if(!bloodDetails.isPresent()) {
			Optional<BloodBank> bloodBank = bloodBankRepository.findById(bd.getBloodBank().getBloodBankId());
			bd.setBloodBank(bloodBank.get());
			bd.setQuantity(1);
			return bloodDetailsRepository.save(bd);
		} 
		bloodDetails.get().setQuantity(bloodDetails.get().getQuantity() + 1);
		return bloodDetailsRepository.save(bloodDetails.get());
		
	}
	
	 @Override
	public void delete(BloodDetails bd) {
		bloodDetailsRepository.delete(bd);
	}
	
	 @Override
	public List<BloodDetails> findAll(){
		return bloodDetailsRepository.findAll();
	}
	
	 @Override
	public Optional<BloodDetails> findOne(Long bdid) {
		
		return bloodDetailsRepository.findById(bdid);
	}
	
	 @Override
	public List<BloodDetails> getBloodBankByLocation(String location){
		return bloodDetailsRepository.getBloodBankByLocation(location);
	}
}
