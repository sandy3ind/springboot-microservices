package com.samplerestaurantservice.rs;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.OptionType;
import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantOptionType;
import com.samplerestaurantservice.respository.OptionTypeRepository;
import com.samplerestaurantservice.respository.RestaurantOptionTypeRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/{restaurantId}/option-type")
public class RestaurantOptionTypeService {
	
	@Autowired
	private RestaurantOptionTypeRepository restaurantOptionTypeRepository;
	
	@Autowired
	private OptionTypeRepository optionTypeRepository;
	
	@PostMapping
	public ResponseEntity<?> save(
			@PathVariable("restaurantId") long restaurantId,
			@Valid @RequestBody RestaurantOptionType restaurantOptionType, Errors errors) {
		
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
		
		restaurantOptionTypeRepository.save(restaurantOptionType);
		
		return ResponseEntity.ok().build();
	}	
	
}
