package com.samplerestaurantservice.respository.cart;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.cart.Cart;
import com.samplerestaurantservice.entity.user.User;

public interface CartRepository extends CrudRepository<Cart, Long> {

	Cart findByUser(User user);
	
//	@Modifying
//    @Query(value = "truncate table carts", nativeQuery = true)
//    void truncate();

}
