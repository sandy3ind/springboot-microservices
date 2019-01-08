package com.samplerestaurantservice.rs;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.Cuisine;
import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.respository.CuisineRepository;
import com.samplerestaurantservice.respository.RestaurantRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/")
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;

	/**
	 * Save/Update Restaurant
	 * 
	 * @param restaurant
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Restaurant restaurant, Errors errors) {
		
		// Validate input values
		if (errors.hasErrors()) {			
			// Build all errors
            Map<String, String> msg = errors.getAllErrors()
				.stream()
				.map(err -> (FieldError) err)
				.collect(Collectors.toMap(FieldError::getField, err -> err.getDefaultMessage()));

            return ResponseEntity.badRequest()
            		.body(new ResponseError(HttpStatus.BAD_REQUEST.value(), ErrorType.VALIDATION, msg));
		}
		
		// Cuisines to the restaurant
		List<Cuisine> requestCuisines = restaurant.getCuisines();
		if (requestCuisines != null && !requestCuisines.isEmpty()) {
			List<Cuisine> cuisines = requestCuisines.stream()
					.map(cuisine -> {
						 return cuisineRepository.findById(cuisine.getId()).get();
					}).collect(Collectors.toList());
			restaurant.setCuisines(cuisines);
		}
		
		restaurant.setCreatedDate(new Date());
		
		// Save to database
		restaurantRepository.save(restaurant);
		
		return ResponseEntity.ok().build();
	}	
	
	@GetMapping
	public ResponseEntity<?> list() {
		List<Restaurant> restaurants = (List<Restaurant>) restaurantRepository.findAll();
		return ResponseEntity.ok(restaurants);
	}
}
