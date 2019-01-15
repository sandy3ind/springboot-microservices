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
@Table(name="restaurant_choice_items")
public class RestaurantChoiceItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_choice_item_id")
	private long id;
	
	@Column(name="price")
	private float price;
	
	@ManyToOne
	@JoinColumn(name="restaurant_choice_id")
	private RestaurantChoice restaurantChoice;
	
	@OneToOne
	@JoinColumn(name="choice_item_id")
	private ChoiceItem ChoiceItem;

	// Constructors
	public RestaurantChoiceItem() {}
	public RestaurantChoiceItem(long id) {
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
	public RestaurantChoice getRestaurantChoice() {
		return restaurantChoice;
	}
	public void setRestaurantChoice(RestaurantChoice restaurantChoice) {
		this.restaurantChoice = restaurantChoice;
	}
	public ChoiceItem getChoiceItem() {
		return ChoiceItem;
	}
	public void setChoiceItem(ChoiceItem choiceItem) {
		ChoiceItem = choiceItem;
	}
}
