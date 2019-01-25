package com.samplerestaurantservice.rs.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.user.Address;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.entity.user.UserAddress;
import com.samplerestaurantservice.respository.user.AddressRepository;
import com.samplerestaurantservice.respository.user.UserAddressRepository;

@RestController
@RequestMapping("/user/{userId}/address")
public class UserAddressService {
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Save/Update UserAddress
	 * 
	 * @param userId
	 * @param userAddress
	 * @return
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(
			@PathVariable("userId") long userId,
			@RequestBody UserAddress userAddress) {
		
		// Create UserAddress relation
		if (userAddress != null) {
			userAddress.setUser(new User(userId));
		}
		
		// Check for Save/Update
		UserAddress userAddressDb = userAddressRepository.findByUserAndAddressType(userAddress.getUser(), 
				userAddress.getAddressType());
		
		// Update 
		if (userAddressDb != null) {
			userAddress.setId(userAddressDb.getId());
			Address addressDb = userAddressDb.getAddress();
			Address address = userAddress.getAddress();
			address.setId(addressDb.getId());
		}
		
		// Save Address
		Address address = addressRepository.save(userAddress.getAddress());
		userAddress.setAddress(address);
		
		// Save UserAddress
		userAddressRepository.save(userAddress);
		
		return ResponseEntity.ok().build();
	}
}
