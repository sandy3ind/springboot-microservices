package com.samplerestaurantservice.respository.cart;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.cart.CartFood;

public interface CartFoodRepository extends CrudRepository<CartFood, Long> {

//	@Modifying
//    @Query(value = "truncate table cart_foods", nativeQuery = true)
//    void truncate();
//	
//	@Modifying
//    @Query(value = "truncate table cart_food_add_on_items", nativeQuery = true)
//    void truncateAddOnItems();
	
	@Modifying	
	@Query("delete from CartFood where id = ?1")
	void delete(Long id);
	
}
