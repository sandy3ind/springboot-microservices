package com.samplerestaurantservice.entity.cart;

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

import org.hibernate.annotations.Cascade;

import com.samplerestaurantservice.entity.user.User;

@Entity
@Table(name="carts")
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="cart", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	private List<CartFood> cartFoods;
	
	@Column(name="total_price")
	private float totalPrice;
	
	// Constructors	
	public Cart() {}
	public Cart(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartFood> getCartFoods() {
		return cartFoods;
	}
	public void setCartFoods(List<CartFood> cartFoods) {
		this.cartFoods = cartFoods;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
}
