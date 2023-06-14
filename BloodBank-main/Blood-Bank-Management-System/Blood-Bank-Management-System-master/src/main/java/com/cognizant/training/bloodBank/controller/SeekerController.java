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

import com.cognizant.training.bloodBank.exception.SeekerNotFoundException;
import com.cognizant.training.bloodBank.model.Seeker;
import com.cognizant.training.bloodBank.service.SeekerService;

@RestController
@RequestMapping("/")
public class SeekerController {

	@Autowired
	SeekerService seekerService;


	@PostMapping("/seeker")
	public Seeker createDonor(@Valid @RequestBody Seeker seeker) {
		
		return seekerService.save(seeker);
	}

	
	@GetMapping("/seeker")
	public List<Seeker> getAllSeekers() {
		System.out.println("getAll");
		return seekerService.findAll();
	}
	
	
	@DeleteMapping("/seeker/{id}")
    public ResponseEntity<Seeker> deleteSeeker(@PathVariable(value = "id") Long sId) {
        Optional<Seeker> seeker = seekerService.findOne(sId);
        if (!seeker.isPresent()) {
            throw new SeekerNotFoundException("Seeker not found with ID: " + sId);
        }

        seekerService.delete(seeker.get());

        return ResponseEntity.ok().build();
    }
	
	@PostMapping("/seeker/login")
	public boolean login(@Valid @RequestBody Seeker donor) {
		return seekerService.login(donor);
	}
	
	@PutMapping("/seeker/")
    public ResponseEntity<Seeker> updateSeeker(@Valid @RequestBody Seeker seeker) {
        Optional<Seeker> seekerOld = seekerService.findOne(seeker.getSeeker_id());
        if (!seekerOld.isPresent()) {
            throw new SeekerNotFoundException("Seeker not found with ID: " + seeker.getSeeker_id());
        }
		seeker.setSeeker_id(seekerOld.get().getSeeker_id());
		
		seekerService.save(seeker);
		 return ResponseEntity.ok().build();

	}
}
