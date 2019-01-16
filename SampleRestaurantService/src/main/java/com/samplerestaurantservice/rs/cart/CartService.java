package com.samplerestaurantservice.rs.cart;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;
import com.samplerestaurantservice.entity.RestaurantFoodOption;
import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.cart.CartFood;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.util.Constant.UpdateQuantityType;

@RestController
@RequestMapping("/cart")
public class CartService {
	
	@Autowired
	private CartCache cartCache;
	
	@GetMapping(value = "/update-quantity/type/{type}/user/{userId}/food/{foodId}")
	public ResponseEntity<?> updateQuantity(
			@PathVariable("type") UpdateQuantityType type,
			@PathVariable("userId") long userId,
			@PathVariable("foodId") long foodId,
			@RequestParam("foodOptionId") long foodOptionId,
			@RequestParam("foodAddOnItemIds") List<Long> foodAddOnItemIds,
			@RequestParam("foodChoiceItemId") long foodChoiceItemId) {	
		
		// Get Cached Cart of this user
		Cart cart = cartCache.getCart(userId);
		
		// Update quantity of food
		List<CartFood> cartFoods = cart.getCartFoods();
		CartFood cartFood = null;
		// When there is no foods added - create
		if (cartFoods == null || cartFoods.isEmpty()) {
			cartFoods = new ArrayList<>(1);
			cartFood = new CartFood();
			cartFood.setQuantity(1);
		}		
		
		boolean foodFound = false;
		
		// Check if same food id coming - update quantity and assign CartFood
		for (CartFood cf : cartFoods) {
			if (cf.getRestaurantFood().getId() == foodId) {
				// If same same food - Update quantity +/-
				updateFoodQuantity(type, cf);
				cartFood = cf;
				foodFound = true;
			}
		}
		
		// If food not found then create new one
		if (!foodFound) {
			cartFood = new CartFood();
			cartFood.setQuantity(1);
			cartFoods.add(cartFood);		
		}
		
		addFood(cartFood, foodId);
		addFoodOption(cartFood, foodOptionId);
		addFoodAddOnItems(cartFood, foodAddOnItemIds);
		addFoodChoiceItem(cartFood, foodChoiceItemId);		
		
		cart.setCartFoods(cartFoods);
		
	  return ResponseEntity.ok(cart);
	}
	
	/**
	 * Update CartFood quantity +/-
	 * 
	 * @param type
	 * @param cartFood
	 */
	private void updateFoodQuantity(UpdateQuantityType type, CartFood cartFood) {
		if (type.equals(UpdateQuantityType.PLUS)) {
			cartFood.setQuantity(cartFood.getQuantity() + 1);
		}
		else if (type.equals(UpdateQuantityType.MINUS) && cartFood.getQuantity() > 0) {
			cartFood.setQuantity(cartFood.getQuantity() - 1);
		}
	}
	
	/**
	 * Add RestaurantFood to Cart
	 * 
	 * @param cartFood
	 * @param foodId
	 */
	private void addFood(CartFood cartFood, long foodId) {
		if (foodId > 0) {
			cartFood.setRestaurantFood(new RestaurantFood(foodId));
		}
	}
	
	/**
	 * Add RestaurantFoodOption to Cart
	 * 
	 * @param cartFood
	 * @param foodOptionId
	 */
	private void addFoodOption(CartFood cartFood, long foodOptionId) {
		if (foodOptionId > 0) {
			cartFood.setRestaurantFoodOption(new RestaurantFoodOption(foodOptionId));
		}
	}
	
	/**
	 * Add RestaurantFoodAddOnItems to Cart
	 * 
	 * @param cartFood
	 * @param addOnItemIds
	 */
	private void addFoodAddOnItems(CartFood cartFood, List<Long> addOnItemIds) {
		if (addOnItemIds != null && !addOnItemIds.isEmpty()) {
			List<RestaurantFoodAddOnItem> addOnItems = addOnItemIds.stream()
					.map(id -> new RestaurantFoodAddOnItem(id)).collect(Collectors.toList());
			cartFood.setRestaurantFoodAddOnItems(addOnItems);
		}
	}
	
	/**
	 * Add RestaurantFoodAddChoice to Cart
	 * 
	 * @param cartFood
	 * @param choiceItemId
	 */
	private void addFoodChoiceItem(CartFood cartFood, long choiceItemId) {
		if (choiceItemId > 0) {
			cartFood.setRestaurantFoodChoiceItem(new RestaurantFoodChoiceItem(choiceItemId));
		}
	}
	
}
