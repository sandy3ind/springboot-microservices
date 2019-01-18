package com.samplerestaurantservice.rs.cart;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.AtomicDouble;
import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;
import com.samplerestaurantservice.entity.RestaurantFoodOption;
import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.cart.CartFood;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.respository.RestaurantFoodAddOnItemRepository;
import com.samplerestaurantservice.respository.RestaurantFoodChoiceItemRepository;
import com.samplerestaurantservice.respository.RestaurantFoodOptionRepository;
import com.samplerestaurantservice.respository.RestaurantFoodRepository;
import com.samplerestaurantservice.respository.cart.CartFoodRepository;
import com.samplerestaurantservice.respository.cart.CartRepository;
import com.samplerestaurantservice.util.Constant.UpdateQuantityType;

@RestController
@RequestMapping("/cart")
public class CartService {
	
	@Autowired
	private CartCache cartCache;
	
	@Autowired
	private RestaurantFoodOptionRepository restaurantFoodOptionRepository;
	
	@Autowired
	private RestaurantFoodRepository restaurantFoodRepository;
	
	@Autowired
	private RestaurantFoodAddOnItemRepository restaurantFoodAddOnItemRepository;
	
	@Autowired
	private RestaurantFoodChoiceItemRepository restaurantFoodChoiceItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartFoodRepository cartFoodRepository;
	
	@Autowired
	private CartCacheService cartCacheService;
	
	
		
	@PostMapping(value = "/user/{userId}")
	@Transactional
	public ResponseEntity<?> saveCart(
			@PathVariable("userId") long userId) {
		
		// Get Cached Cart of this user
		Cart cachedCart = cartCache.getCart(userId);
		
		// Get Cart from DB if exists of this user
		Cart cartDb = cartRepository.findByUser(new User(userId));
		
		// Assigned any data from Cached Cart in Cart in DB
		if (cartDb != null) {
			//TODO - assign more
			cachedCart.setId(cartDb.getId());
			// Delete all the CartFoods in DB
			deleteCartFoods(cartDb.getCartFoods());
		}		
			
		List<CartFood> cartFoods = cachedCart.getCartFoods();	
		
		// Iterate over CartFoods
		if (cartFoods != null && !cartFoods.isEmpty()) {			
			cartFoods.forEach(cartFood -> {
				// Save CartFood - AddOnItems relation if exists
				List<RestaurantFoodAddOnItem> addOnItems = cartFood.getRestaurantFoodAddOnItems();
				if (addOnItems != null && !addOnItems.isEmpty()) {
					List<RestaurantFoodAddOnItem> newAddOnItems = addOnItems.stream()
							.map(addOnItem -> {
								return restaurantFoodAddOnItemRepository.findById(addOnItem.getId()).get();
							}).collect(Collectors.toList());
					cartFood.setRestaurantFoodAddOnItems(newAddOnItems);
				}
				// Add CartFood Total price
				cartCacheService.calculateCartFoodTotalPrice(cartFood);
			});
		}		
		
		// HACK - Update Cart in the CartFood - somehow cart_id is not being updated in cart_food table 
		cachedCart.getCartFoods().forEach(cartFood -> cartFood.setCart(cachedCart));
		cartRepository.save(cachedCart);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Delete all the CartFoods of the Cart
	 * 
	 * @param cartFoods
	 */
	private void deleteCartFoods(List<CartFood> cartFoods) {
		cartFoods.forEach(cartFood -> {			
			cartFoodRepository.delete(cartFood.getId());			
		});
	}
	
}
