package com.samplerestaurantservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_foods")
public class RestaurantFood {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_food_id")
	private long id;	
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price; // Price shown on the list (lowest price)
	
	@Column(name="discount") // discount related to price shown
	private float discount;
	
	@Column(name="customizable")
	private boolean customizable = false;
	
	@ManyToOne
	@JoinColumn(name="restaurant_category_id")
	private RestaurantCategory restaurantCategory;
	
	@ManyToOne
	@JoinColumn(name="restaurant_menu_id")
	private RestaurantMenu restaurantMenu;
	
	// Constructors
	public RestaurantFood() {}	
	public RestaurantFood(long id) {
		this.id = id;
	}
	// Copy constructor
	public RestaurantFood(RestaurantFood restaurantFood) {
		this(restaurantFood.getId());
		this.setName(restaurantFood.getName());
		this.setDiscount(restaurantFood.getDiscount());
		this.setCustomizable(restaurantFood.isCustomizable());
		this.setRestaurantCategory(restaurantCategory);
		//this.setRestaurantMenu(restaurantMenu);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantCategory getRestaurantCategory() {
		return restaurantCategory;
	}

	public void setRestaurantCategory(RestaurantCategory restaurantCategory) {
		this.restaurantCategory = restaurantCategory;
	}

	public RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isCustomizable() {
		return customizable;
	}

	public void setCustomizable(boolean customizable) {
		this.customizable = customizable;
	}
}
