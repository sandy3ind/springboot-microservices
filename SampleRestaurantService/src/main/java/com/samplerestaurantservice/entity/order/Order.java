package com.samplerestaurantservice.entity.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.samplerestaurantservice.entity.Restaurant;
import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.util.Constant;

@Entity
@Table(name="orders")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;

	@OneToMany(mappedBy="order", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	private List<OrderFood> orderFoods;
	
	@Column(name="total_price")
	private float totalPrice;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="final_price")
	private float finalPrice;
	
	@Column(name="status")
	private Constant.OrderStatus status;

	@OneToOne
	@JoinColumn(name="order_rejection_reason_id")
	private OrderRejectionReason orderRejectionReason;
	
	// Builder Order from Cart
	public Order buildOrderFromCart(Cart cart) {
		this.setDiscount(cart.getDiscount());
		this.setFinalPrice(cart.getFinalPrice());
		this.setTotalPrice(cart.getTotalPrice());
		this.setUser(cart.getUser());
		this.setRestaurant(cart.getRestaurant());
		return this;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderFood> getOrderFoods() {
		return orderFoods;
	}

	public void setOrderFoods(List<OrderFood> orderFoods) {
		this.orderFoods = orderFoods;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Constant.OrderStatus getStatus() {
		return status;
	}

	public void setStatus(Constant.OrderStatus status) {
		this.status = status;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public OrderRejectionReason getOrderRejectionReason() {
		return orderRejectionReason;
	}

	public void setOrderRejectionReason(OrderRejectionReason orderRejectionReason) {
		this.orderRejectionReason = orderRejectionReason;
	}
	
}
