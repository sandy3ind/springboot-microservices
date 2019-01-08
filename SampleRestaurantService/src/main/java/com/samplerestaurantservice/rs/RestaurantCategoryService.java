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

import com.samplerestaurantservice.entity.Category;
import com.samplerestaurantservice.entity.Menu;
import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantCategory;
import com.samplerestaurantservice.entity.RestaurantMenu;
import com.samplerestaurantservice.respository.CategoryRepository;
import com.samplerestaurantservice.respository.MenuRepository;
import com.samplerestaurantservice.respository.RestaurantCategoryRepository;
import com.samplerestaurantservice.respository.RestaurantMenuRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/{restaurantMenuId}/category")
public class RestaurantCategoryService {
	
	@Autowired
	private RestaurantCategoryRepository restaurantCategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Save/Update RestaurantMenu Category
	 * 
	 * @param restaurantMenuId
	 * @param restaurantCategory
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(
			@PathVariable("restaurantMenuId") long restaurantMenuId,
			@Valid @RequestBody RestaurantCategory restaurantCategory, Errors errors) {
		
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
		
		// Set RestaurantMenu object
		restaurantCategory.setRestaurantMenu(new RestaurantMenu(restaurantMenuId));
		
		// Set Category to restaurant
		Category category = restaurantCategory.getCategory();
		if (category != null) {
			restaurantCategory.setCategory(categoryRepository.findById(category.getId()).get());
		}
		
		restaurantCategoryRepository.save(restaurantCategory);
		
		return ResponseEntity.ok().build();
	}	
	
	/**
	 * List of all Categories by Restaurant Menu
	 * 
	 * @param restaurantMenuId
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> listByRestaurantMenu(
			@PathVariable("restaurantMenuId") long restaurantMenuId) {
		List<RestaurantCategory> restaurantCategories = 
				restaurantCategoryRepository.findByRestaurantMenu(new RestaurantMenu(restaurantMenuId));
		return ResponseEntity.ok(restaurantCategories);
	}
	
}
