package com.samplerestaurantservice.rs.admin;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.Category;
import com.samplerestaurantservice.entity.Menu;
import com.samplerestaurantservice.respository.CategoryRepository;
import com.samplerestaurantservice.respository.MenuRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/admin/menu")
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Menu menu, Errors errors) {
		
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
		
		menuRepository.save(menu);
		
		return ResponseEntity.ok().build();
	}
}
