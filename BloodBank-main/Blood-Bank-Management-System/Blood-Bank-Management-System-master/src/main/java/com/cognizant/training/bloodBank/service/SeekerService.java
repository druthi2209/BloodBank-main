package com.cognizant.training.bloodBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.Seeker;

@Service
public interface SeekerService {

	Seeker save(Seeker seeker);
	
	void delete(Seeker seeker);
	
	List<Seeker> findAll();
	
	Optional<Seeker> findOne(Long sid);
	
	boolean login(Seeker seeker);
}
