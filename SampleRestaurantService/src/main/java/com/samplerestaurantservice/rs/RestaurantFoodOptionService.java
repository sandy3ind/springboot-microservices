package com.samplerestaurantservice.rs;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodOption;
import com.samplerestaurantservice.respository.RestaurantFoodOptionRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/food/{restaurantFoodId}/option")
public class RestaurantFoodOptionService {
	
	@Autowired
	private RestaurantFoodOptionRepository restaurantFoodOptionRepository;
	
	@PostMapping
	public ResponseEntity<?> save(
			@PathVariable("restaurantFoodId") long restaurantFoodId,
			@Valid @RequestBody RestaurantFoodOption restaurantFoodOption, Errors errors) {
		
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
		
		// Set RestaurantFood
		restaurantFoodOption.setRestaurantFood(new RestaurantFood(restaurantFoodId));
		
		restaurantFoodOptionRepository.save(restaurantFoodOption);
		
		return ResponseEntity.ok().build();
	}	
	
	
	/**
	 * Get Restaurant Options
	 * 
	 * @param restaurantFoodId
	 * @return
	 */	
	@GetMapping
	public ResponseEntity<?> getOptions(
			@PathVariable("restaurantFoodId") long restaurantFoodId) {
		
		// Fetch Restaurant Food Options
		List<RestaurantFoodOption> options = restaurantFoodOptionRepository.findByRestaurantFood(new RestaurantFood(restaurantFoodId));
		
		if (options != null && !options.isEmpty()) {
			List<RestaurantFoodOption> newOptions = options.stream()
					.map(op -> {
						return new RestaurantFoodOption(op);
					}).collect(Collectors.toList());
			return ResponseEntity.ok(newOptions);
		}
		
		return ResponseEntity.ok(Collections.emptyList());
	}
	
}
