package com.cognizant.training.bloodBank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.Seeker;
import com.cognizant.training.bloodBank.repository.SeekerRepository;
import com.cognizant.training.bloodBank.service.SeekerService;

@Service
public class SeekerServiceImpl implements SeekerService{

	@Autowired
	SeekerRepository seekerRepository;
	
	@Override
	public Seeker save(Seeker seeker) {
		return seekerRepository.save(seeker);
	}
	
	@Override
	public void delete(Seeker seeker) {
		seekerRepository.delete(seeker);
	}
	
	@Override
	public List<Seeker> findAll(){
		return seekerRepository.findAll();
	}
	
	@Override
	public Optional<Seeker> findOne(Long sid) {
		
		return seekerRepository.findById(sid);
	}
	
	@Override
	public  boolean login(Seeker seeker) {
		return seekerRepository.seekerLogin(seeker.getEmail(),seeker.getPassword())==null?false:true;
	}
}
