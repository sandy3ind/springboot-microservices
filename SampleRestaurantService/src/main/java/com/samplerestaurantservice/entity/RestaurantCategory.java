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
@Table(name="restaurant_categories")
public class RestaurantCategory {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_category_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="restaurant_menu_id")
	private RestaurantMenu restaurantMenu;
	
	// Constructors
	public RestaurantCategory() {}
	public RestaurantCategory(long id) {
		this.id = id;
	}
	// Copy constructor
	public RestaurantCategory(RestaurantCategory restaurantCategory) {
		this(restaurantCategory.getId());		
		this.category = new Category(restaurantCategory.getCategory());
		//this.restaurantMenu = new RestaurantMenu(restaurantCategory.getRestaurantMenu());
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}
}
