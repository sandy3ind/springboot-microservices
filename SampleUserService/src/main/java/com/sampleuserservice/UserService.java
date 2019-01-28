package com.sampleuserservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampleuserservice.entity.Device;
import com.sampleuserservice.entity.Role;
import com.sampleuserservice.entity.User;
import com.sampleuserservice.repository.DeviceRepository;
import com.sampleuserservice.repository.RoleRepository;
import com.sampleuserservice.repository.UserRepository;
import com.sampleuserservice.util.Constant.ErrorType;
import com.sampleuserservice.util.ResponseError;


@RestController
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	/**
	 * Save User
	 * 
	 * @param user
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody User user, Errors errors) {
		
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
		
		// Save user to database
		if (user.getId() > 0) {
			User userDb = userRepository.findById(user.getId()).get();
			userDb.setName(user.getName());
			userDb.setModifiedTime(new Date());
			userRepository.save(userDb);
		}
		else {
			// Check if Phone already exists
			Long pcount = userRepository.countByPhone(user.getPhone());
			if (pcount > 0) {
				return ResponseEntity.badRequest()
	            		.body(new ResponseError(
	            				HttpStatus.BAD_REQUEST.value(), 
	            				ErrorType.NON_UNIQUE, "Phone already exists"));
			}			
			
			// Check if Email already exists
			Long ecount = userRepository.countByEmail(user.getEmail());
			if (ecount > 0) {
				return ResponseEntity.badRequest()
	            		.body(new ResponseError(
	            				HttpStatus.BAD_REQUEST.value(), 
	            				ErrorType.NON_UNIQUE, "Email already exists"));
			}
			
			// Add roles
			if (user.getRoles() != null && !user.getRoles().isEmpty()) {
				List<Role> roles = user.getRoles().stream()
						.map(role -> roleRepository.findByRole(role.getRole()))
						.collect(Collectors.toList());
				user.setRoles(roles);
			}
			
			user.setInsertedTime(new Date());
			userRepository.save(user);
		}
		
		return ResponseEntity.ok().build();
	}
		
	/**
	 * Get User by phone
	 * 
	 * @param phone
	 * @return
	 */
	@GetMapping("/phone/{phone}")
	public ResponseEntity<?> getUserByPhone(@PathVariable("phone") String phone) {
		
		User user = userRepository.findByPhone(phone);
			
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Save/Update User's device FCM token - will be need to send FCM notification to user's device
	 * 
	 * @param userId
	 * @param token
	 * @return
	 */
	@PostMapping("{userId}/fcm/{token}")
	public ResponseEntity<?> registerFcm(
			@PathVariable("userId") long userId,
			@PathVariable("token") String token) {
		
		Device device = deviceRepository.findByUser(new User(userId));
		
		if (device != null) {
			device.setFcmToken(token);
		}
		else {
			device = new Device();
			device.setFcmToken(token);
			device.setUser(new User(userId));
		}
		deviceRepository.save(device);
		
		return ResponseEntity.ok().build();
	}
	

}
