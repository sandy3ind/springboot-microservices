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
@Table(name="restaurant_add_on_items")
public class RestaurantAddOnItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_add_on_item_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="restaurant_add_on_id")
	private RestaurantAddOn restaurantAddOn;
	
	@OneToOne
	@JoinColumn(name="add_on_item_id")
	private AddOnItem addOnItem;
	
	// Constructors
	public RestaurantAddOnItem() {}
	public RestaurantAddOnItem(long id) {	
		this.id = id;
	}
	
	public long getId() {
		return id;
	}	

	public void setId(long id) {
		this.id = id;
	}

	public RestaurantAddOn getRestaurantAddOn() {
		return restaurantAddOn;
	}

	public void setRestaurantAddOn(RestaurantAddOn restaurantAddOn) {
		this.restaurantAddOn = restaurantAddOn;
	}

	public AddOnItem getAddOnItem() {
		return addOnItem;
	}

	public void setAddOnItem(AddOnItem addOnItem) {
		this.addOnItem = addOnItem;
	}
	
}
