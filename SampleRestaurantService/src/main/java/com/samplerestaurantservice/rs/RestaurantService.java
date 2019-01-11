package com.samplerestaurantservice.rs;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.Cuisine;
import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantMenu;
import com.samplerestaurantservice.respository.CuisineRepository;
import com.samplerestaurantservice.respository.RestaurantMenuRepository;
import com.samplerestaurantservice.respository.RestaurantRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.GoogleMapUtility;
import com.samplerestaurantservice.util.ResponseError;
import com.samplerestaurantservice.util.Utility;

@RestController
@RequestMapping("/")
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private RestaurantMenuRepository restaurantMenuRepository;
	
	

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
	
	/**
	 * Get all Restaurants
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> list() {
		List<Restaurant> restaurants = (List<Restaurant>) restaurantRepository.findAll();
		return ResponseEntity.ok(restaurants);
	}
	
	/**
	 * Fetch all/search the Nearest Restaurants within given Distance
	 * 
	 * @param lat
	 * @param lng
	 * @param distance
	 * @param page
	 * @param limit
	 * @param search
	 * @return
	 */
	@GetMapping("nearest/lat/{lat}/lng/{lng}/distance/{distance}/page/{page}/limit/{limit}")
	public ResponseEntity<?> nearBy(
			@PathVariable("lat") double lat,
			@PathVariable("lng") double lng,
			@PathVariable("distance") double distance,
			@PathVariable("page") int page,
			@PathVariable("limit") int limit,
			@RequestParam(name="search", required=false) String search) {
		
		Pageable pageable = PageRequest.of(page, limit);
		
		// Do not pass null to query
		if (search == null) {
			search = "";
		}
		
		List<Restaurant> restaurants = restaurantRepository.findNearestRestaurants(lat, lng, distance, search, pageable);
		
		if (restaurants != null && !restaurants.isEmpty()) {
			List<Restaurant> newRestaurants = restaurants.stream()
					.map(r -> {
						double distance1 = GoogleMapUtility.calculateDistance(lat, lng, r.getLatitude(), r.getLongitude());
						r.setDistance(Utility.limitDecimal(distance1, 1));
						return r;
					}).collect(Collectors.toList());
			return ResponseEntity.ok(newRestaurants);
		}
		
		return ResponseEntity.ok(restaurants);
	}
	
	/**
	 * Get Restaurant complete detail
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("{id}/detail")
	public ResponseEntity<?> detail(
			@PathVariable("id") long id) {
		
		Restaurant restaurant = restaurantRepository.findById(id).get();		
		
		// If restaurant is null then return NoContent
		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Make fresh copy of restaurant		
		restaurant = new Restaurant(restaurant);
		
		// Set Menus
		List<RestaurantMenu> restaurantMenus = restaurantMenuRepository.findByRestaurant(restaurant);
		if (restaurantMenus != null) {
			List<RestaurantMenu> newRestaurantMenus = restaurantMenus.stream()
					.map(menu -> new RestaurantMenu(menu)).collect(Collectors.toList());
			restaurant.setMenus(newRestaurantMenus);
		}	
				
		return ResponseEntity.ok(restaurant);
	}
}
