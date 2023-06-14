package com.cognizant.training.bloodBank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.model.Donor;
import com.cognizant.training.bloodBank.repository.BloodBankRepository;
import com.cognizant.training.bloodBank.repository.DonorRepository;
import com.cognizant.training.bloodBank.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService{
	
	@Autowired
	BloodBankRepository bloodBankRepository;

	@Autowired
	DonorRepository donorRepository;
	
	@Override
	public Donor save(Donor donor) {
		Optional<BloodBank> bloodBank = bloodBankRepository.findById(donor.getBloodBank().getBloodBankId());
		donor.setBloodBank(bloodBank.get());
		return donorRepository.save(donor);
	}
	
	@Override
	public void delete(Donor donor) {
		donorRepository.delete(donor);
	}
	
	@Override
	public Donor findOneByEmail(String email) {
		
		return donorRepository.findOneByEmail(email);
	}
	
	@Override
	public List<Donor> findAll(){
		return donorRepository.findAll();
	}
	
	@Override
	public Optional<Donor> findOne(Long did) {
		
		return donorRepository.findById(did);
	}
	
	@Override
	public  Donor login(Donor donor) {
		return donorRepository.donorLogin(donor.getEmail(),donor.getPassword());
	}
	
	@Override
	public List<Donor>  getDonorByLocation(String location){
		return donorRepository.getDonorByLocation(location);
	}
}
