package com.samplerestaurantservice.entity.cart;

import java.util.List;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;
import com.samplerestaurantservice.entity.RestaurantFoodOption;

public class CartFood {
	
	private long id;
	private RestaurantFood restaurantFood;
	private RestaurantFoodOption restaurantFoodOption;
	private List<RestaurantFoodAddOnItem> restaurantFoodAddOnItems;
	private RestaurantFoodChoiceItem restaurantFoodChoiceItem;
	private int quantity;
	private float price;
	private float totalPrice;
	
	private Cart cart;
}
