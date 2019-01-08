package com.samplerestaurantservice.rs.admin;

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
import com.samplerestaurantservice.respository.CategoryRepository;
import com.samplerestaurantservice.respository.MenuRepository;
import com.samplerestaurantservice.util.Constant.ErrorType;
import com.samplerestaurantservice.util.ResponseError;

@RestController
@RequestMapping("/admin/category")
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	/**
	 * Save/Update Category
	 * 
	 * @param category
	 * @param errors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Category category, Errors errors) {
		
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
		
		// Add menu object
		Menu menu = category.getMenu();
		if (menu != null) {
			category.setMenu(menuRepository.findById(menu.getId()).get());
		}
		
		categoryRepository.save(category);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Get Categories by menu id
	 * 
	 * @param menuId
	 * @return
	 */
	@GetMapping("menu/{menuId}")
	public ResponseEntity<?> listByMenu(
			@PathVariable("menuId") long menuId) {
		List<Category> categories = categoryRepository.findByMenu(new Menu(menuId));
		return ResponseEntity.ok(categories);
	}
}
