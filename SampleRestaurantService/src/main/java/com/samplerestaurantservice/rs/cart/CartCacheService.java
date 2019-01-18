package com.samplerestaurantservice.rs.cart;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.samplerestaurantservice.respository.RestaurantFoodAddOnItemRepository;
import com.samplerestaurantservice.respository.RestaurantFoodChoiceItemRepository;
import com.samplerestaurantservice.respository.RestaurantFoodOptionRepository;
import com.samplerestaurantservice.respository.RestaurantFoodRepository;
import com.samplerestaurantservice.respository.cart.CartFoodRepository;
import com.samplerestaurantservice.respository.cart.CartRepository;
import com.samplerestaurantservice.util.Constant.UpdateQuantityType;

@RestController
@RequestMapping("/cart/cache")
public class CartCacheService {
	
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
	
	/**
	 * Save Cart details into Cache
	 * Add new Food if Cart is empty
	 * Increment/Decrement quantity of Food and its other parts
	 * 
	 * @param type
	 * @param userId
	 * @param foodId
	 * @param foodOptionId
	 * @param foodAddOnItemIds
	 * @param foodChoiceItemId
	 * @return
	 */
	@GetMapping(value = "/update-quantity/type/{type}/user/{userId}/food/{foodId}")
	public ResponseEntity<?> updateQuantity(
			@PathVariable("type") UpdateQuantityType type,
			@PathVariable("userId") long userId,			
			@PathVariable("foodId") long foodId,
			@RequestParam(value="foodOptionId", required=false) long foodOptionId,
			@RequestParam(value="foodAddOnItemIds", required=false) List<Long> foodAddOnItemIds,
			@RequestParam(value="foodChoiceItemId", required=false) long foodChoiceItemId) {	
		
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
		
		//TODO - Add new Food if any change detected in Food, FoodOption, AddOnItems, ChoiceItem
		// Check if same food id coming - update quantity and assign CartFood
		for (CartFood cf : cartFoods) {
			//TODO - Add new Food if any change detected in Food, FoodOption, AddOnItems, ChoiceItem
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
		
		// Calculate Cart Total Price
		calculateCartTotalPrice(cart);
		
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
	
	/**
	 * Calculate Total Price of Cart
	 * 
	 * @param cart
	 */
	public void calculateCartTotalPrice(Cart cart) {		
		List<CartFood> cartFoods = cart.getCartFoods();	
		cart.setTotalPrice(0); // Reset before calculating - to remove previous cached price
		cart.setFinalPrice(0);
		cartFoods.forEach(cartFood -> {			
			calculateCartFoodPrice(cartFood);
			cart.setTotalPrice(cart.getTotalPrice() + cartFood.getTotalPrice());
			cart.setFinalPrice(cart.getFinalPrice() + cartFood.getFinalPrice());			
		});		
		// Set total discount
		cart.setDiscount(cart.getTotalPrice() - cart.getFinalPrice());
	}
	
	/**
	 * Calculate Total Price of CartFood
	 * 
	 * @param cartFood
	 */
	public void calculateCartFoodPrice(CartFood cartFood) {
		cartFood.setTotalPrice(0); // Reset before calculating - to remove previous cached price
		cartFood.setFinalPrice(0);
		// If FoodOption is there then get its price
		if (cartFood.getRestaurantFoodOption() != null && cartFood.getRestaurantFoodOption().getId() > 0) {
			RestaurantFoodOption restaurantFoodOption = restaurantFoodOptionRepository.findById(cartFood.getRestaurantFoodOption().getId()).get();				
			cartFood.setTotalPrice(cartFood.getTotalPrice() + restaurantFoodOption.getPrice());
			cartFood.setDiscount(restaurantFoodOption.getDiscount());
		}
		else {
			// If Food Option is not there, then get price of Food only
			RestaurantFood restaurantFood = restaurantFoodRepository.findById(cartFood.getRestaurantFood().getId()).get();				
			cartFood.setTotalPrice(cartFood.getTotalPrice() + restaurantFood.getPrice());
			cartFood.setDiscount(restaurantFood.getDiscount());
		}
		// Add prices of any AddOns
		List<RestaurantFoodAddOnItem> addOnItems = cartFood.getRestaurantFoodAddOnItems();
		if (addOnItems != null && !addOnItems.isEmpty()) {
			addOnItems.forEach(item -> {
				Optional<RestaurantFoodAddOnItem> optional = restaurantFoodAddOnItemRepository.findById(item.getId());	
				if (optional.isPresent()) {
					cartFood.setTotalPrice(cartFood.getTotalPrice() + optional.get().getPrice());
				}
			});
		}
		// Add price of any Choice Item
		Optional<RestaurantFoodChoiceItem> optional = restaurantFoodChoiceItemRepository
				.findById(cartFood.getRestaurantFoodChoiceItem().getId());
		if (optional != null && optional.isPresent()) {
			cartFood.setTotalPrice(cartFood.getTotalPrice() + optional.get().getPrice());
		}
		
		//Multiply totalPrice with quantity
		cartFood.setTotalPrice(cartFood.getTotalPrice() * cartFood.getQuantity());
		
		//TODO - Minus any discount applied on the Food
		float totalPrice = cartFood.getTotalPrice();
		float discount = cartFood.getDiscount() * cartFood.getQuantity();
		float finalPrice = totalPrice - discount;
		cartFood.setFinalPrice(finalPrice);
	}
	
}
