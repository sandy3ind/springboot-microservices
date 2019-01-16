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
@Table(name="restaurant_choices")
public class RestaurantChoice {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_choice_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="choice_id")
	private Choice choice;
	
	@OneToMany(mappedBy="restaurantChoice")
	private List<RestaurantChoiceItem> choiceItems;

	// Constructors
	public RestaurantChoice() {}
	public RestaurantChoice(long id) {
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

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}
	public List<RestaurantChoiceItem> getChoiceItems() {
		return choiceItems;
	}
	public void setChoiceItems(List<RestaurantChoiceItem> choiceItems) {
		this.choiceItems = choiceItems;
	}
}
