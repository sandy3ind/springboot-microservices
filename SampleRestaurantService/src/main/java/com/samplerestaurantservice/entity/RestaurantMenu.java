package com.samplerestaurantservice.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="restaurant_menus")
public class RestaurantMenu {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_menu_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@OneToOne
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	@OneToMany(mappedBy="restaurantMenu")
	private List<RestaurantCategory> categories;
	
	@OneToMany(mappedBy="restaurantMenu")
	private List<RestaurantFood> foods;	
	
	// Constructors
	public RestaurantMenu() {}
	
	public RestaurantMenu(long id) {
		this.id = id;
	}	

	// Copy Constructors
	public RestaurantMenu(RestaurantMenu restaurantMenu) {
		this(restaurantMenu.getId());		
		this.menu = new Menu(restaurantMenu.getMenu());
		
		/*if (restaurantMenu.getCategories() != null && !restaurantMenu.getCategories().isEmpty()) {
			this.categories = restaurantMenu.getCategories().stream()
				.map(cat -> new RestaurantCategory(cat)).collect(Collectors.toList());
		}
		if (restaurantMenu.getFoods() != null && !restaurantMenu.getFoods().isEmpty()) {
			this.foods = restaurantMenu.getFoods().stream()
					.map(food -> new RestaurantFood(food)).collect(Collectors.toList());
		}
		this.restaurant = new Restaurant(restaurantMenu.getRestaurant());
		*/
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<RestaurantCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<RestaurantCategory> categories) {
		this.categories = categories;
	}

	public List<RestaurantFood> getFoods() {
		return foods;
	}

	public void setFoods(List<RestaurantFood> foods) {
		this.foods = foods;
	}
}
