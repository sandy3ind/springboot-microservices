package com.samplerestaurantservice.rs.user;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userId}")
public class UserAddressService {

	
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(
			@PathVariable("userId") long userId) {
		
		return ResponseEntity.ok().build();
	}
}
