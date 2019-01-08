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
import com.samplerestaurantservice.entity.RestaurantMenu;
import com.samplerestaurantservice.respository.MenuRepository;
import com.samplerestaurantservice.respository.RestaurantMenuRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/{restaurantId}/menu")
public class RestaurantMenuService {
	
	@Autowired
	private RestaurantMenuRepository restaurantMenuRepository;
	
	@Autowired
	private MenuRepository menuRepository;

	/**
	 * Save/Update Restaurant Menu
	 * 
	 * @param restaurantMenu
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(
			@PathVariable("restaurantId") long restaurantId,
			@Valid @RequestBody RestaurantMenu restaurantMenu, Errors errors) {
		
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
		
		// Set Restaurant object
		restaurantMenu.setRestaurant(new Restaurant(restaurantId));
		
		// Set menu to restaurant
		Menu menu = restaurantMenu.getMenu();
		if (menu != null) {
			restaurantMenu.setMenu(menuRepository.findById(menu.getId()).get());
		}
		
		restaurantMenuRepository.save(restaurantMenu);
		
		return ResponseEntity.ok().build();
	}	
	
	/**
	 * List Restaurant all Menus
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> list(
			@PathVariable("restaurantId") long restaurantId) {
		List<RestaurantMenu> restaurantMenus = restaurantMenuRepository.findByRestaurant(new Restaurant(restaurantId));
		return ResponseEntity.ok(restaurantMenus);
	}
	
}
