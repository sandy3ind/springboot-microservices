package com.samplerestaurantservice.entity.cart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.samplerestaurantservice.entity.RestaurantFood;
import com.samplerestaurantservice.entity.RestaurantFoodAddOnItem;
import com.samplerestaurantservice.entity.RestaurantFoodChoiceItem;
import com.samplerestaurantservice.entity.RestaurantFoodOption;

@Entity
@Table(name="cart_foods")
public class CartFood {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_food_id")
	private long id;	

	@OneToOne
	@JoinColumn(name="restaurant_food_id")
	private RestaurantFood restaurantFood;
	
	@OneToOne
	@JoinColumn(name="restaurant_food_option_id")
	private RestaurantFoodOption restaurantFoodOption;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinTable(
        name = "cart_food_add_on_items", 
        joinColumns = { @JoinColumn(name = "cart_food_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "restaurant_food_add_on_item_id") }
    )
	private List<RestaurantFoodAddOnItem> restaurantFoodAddOnItems;
	
	@OneToOne
	@JoinColumn(name="restaurant_food_choice_item_id")
	private RestaurantFoodChoiceItem restaurantFoodChoiceItem;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="totalPrice")
	private float totalPrice;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RestaurantFood getRestaurantFood() {
		return restaurantFood;
	}

	public void setRestaurantFood(RestaurantFood restaurantFood) {
		this.restaurantFood = restaurantFood;
	}

	public RestaurantFoodOption getRestaurantFoodOption() {
		return restaurantFoodOption;
	}

	public void setRestaurantFoodOption(RestaurantFoodOption restaurantFoodOption) {
		this.restaurantFoodOption = restaurantFoodOption;
	}

	public List<RestaurantFoodAddOnItem> getRestaurantFoodAddOnItems() {
		return restaurantFoodAddOnItems;
	}

	public void setRestaurantFoodAddOnItems(List<RestaurantFoodAddOnItem> restaurantFoodAddOnItems) {
		this.restaurantFoodAddOnItems = restaurantFoodAddOnItems;
	}

	public RestaurantFoodChoiceItem getRestaurantFoodChoiceItem() {
		return restaurantFoodChoiceItem;
	}

	public void setRestaurantFoodChoiceItem(RestaurantFoodChoiceItem restaurantFoodChoiceItem) {
		this.restaurantFoodChoiceItem = restaurantFoodChoiceItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
