package com.samplerestaurantservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_add_ons")
public class RestaurantAddOn {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_add_on_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="_id")
	private AddOn addOn;
	
	@OneToMany(mappedBy="restaurantAddOn")
	private List<RestaurantAddOnItem> addOnItems;

	// Constructor
	public RestaurantAddOn() {}
	public RestaurantAddOn(long id) {		
		this.id = id;
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
	public List<RestaurantAddOnItem> getAddOnItems() {
		return addOnItems;
	}
	public void setAddOnItems(List<RestaurantAddOnItem> addOnItems) {
		this.addOnItems = addOnItems;
	}
	public AddOn getAddOn() {
		return addOn;
	}
	public void setAddOn(AddOn addOn) {
		this.addOn = addOn;
	}
}
