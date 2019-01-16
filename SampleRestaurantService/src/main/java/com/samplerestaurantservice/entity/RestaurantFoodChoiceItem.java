package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_food_choice_items")
public class RestaurantFoodChoiceItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_food_choice_item_id")
	private long id;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne
	@JoinColumn(name="restaurant_food_id")
	private RestaurantFood restaurantFood;
	
	@ManyToOne
	@JoinColumn(name="restaurant_choice_item_id")
	private RestaurantChoiceItem restaurantChoiceItem;
	
	// Constructors
	public RestaurantFoodChoiceItem() {}
	public RestaurantFoodChoiceItem(long id) {
		this.id = id;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public RestaurantFood getRestaurantFood() {
		return restaurantFood;
	}
	public void setRestaurantFood(RestaurantFood restaurantFood) {
		this.restaurantFood = restaurantFood;
	}
	public RestaurantChoiceItem getRestaurantChoiceItem() {
		return restaurantChoiceItem;
	}
	public void setRestaurantChoiceItem(RestaurantChoiceItem restaurantChoiceItem) {
		this.restaurantChoiceItem = restaurantChoiceItem;
	}
}
