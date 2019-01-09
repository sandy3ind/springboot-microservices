package com.samplerestaurantservice.rs;

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

import com.samplerestaurantservice.entity.Menu;
import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantCategory;
import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantMenu;
import com.samplerestaurantservice.respository.CategoryRepository;
import com.samplerestaurantservice.respository.MenuRepository;
import com.samplerestaurantservice.respository.RestaurantCategoryRepository;
import com.samplerestaurantservice.respository.RestaurantFoodRepository;
import com.samplerestaurantservice.respository.RestaurantMenuRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/food")
public class RestaurantFoodService {
	
	@Autowired
	private RestaurantMenuRepository restaurantMenuRepository;
	
	@Autowired
	private RestaurantCategoryRepository restaurantCategoryRepository;
	
	@Autowired
	private RestaurantFoodRepository restaurantFoodRepository;
	
	@PostMapping
	public ResponseEntity<?> save(
			@Valid @RequestBody RestaurantFood restaurantFood, Errors errors) {
		
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
		
		// Set Restaurant Menu object
		RestaurantMenu restaurantMenu = restaurantFood.getRestaurantMenu();
		if (restaurantMenu != null) {
			restaurantFood.setRestaurantMenu(restaurantMenuRepository.findById(restaurantMenu.getId()).get());
		}
						
		// Set RestaurantCategory Object
		RestaurantCategory restaurantCategory = restaurantFood.getRestaurantCategory();
		if (restaurantCategory != null) {
			restaurantFood.setRestaurantCategory(restaurantCategoryRepository.findById(restaurantCategory.getId()).get());
		}
		
		restaurantFoodRepository.save(restaurantFood);
		
		return ResponseEntity.ok().build();
	}
	
}
