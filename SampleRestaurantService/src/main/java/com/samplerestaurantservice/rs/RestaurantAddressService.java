package com.samplerestaurantservice.rs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.RestaurantAddress;
import com.samplerestaurantservice.entity.user.Address;
import com.samplerestaurantservice.respository.RestaurantAddressRepository;
import com.samplerestaurantservice.respository.user.AddressRepository;

@RestController
@RequestMapping("/{restaurantId}/address")
public class RestaurantAddressService {

	@Autowired
	private RestaurantAddressRepository restaurantAddressRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(
			@PathVariable("restaurantId") long restaurantId,
			@RequestBody RestaurantAddress restaurantAddress) {
		
		if (restaurantAddress != null) {
			restaurantAddress.setRestaurant(new Restaurant(restaurantId));
		}
		
		// Check for Save/Update
		RestaurantAddress restaurantAddressDb = restaurantAddressRepository.findByRestaurant(new Restaurant(restaurantId));
		// Update
		if (restaurantAddressDb != null) {
			restaurantAddress.setId(restaurantAddressDb.getId());
			restaurantAddress.getAddress().setId(restaurantAddressDb.getAddress().getId());			
		}
		// Save Address
		Address address = addressRepository.save(restaurantAddress.getAddress());
		restaurantAddress.setAddress(address);
		
		// Save RestaurantAddress
		restaurantAddressRepository.save(restaurantAddress);
		
		return ResponseEntity.ok().build();
	}
}
