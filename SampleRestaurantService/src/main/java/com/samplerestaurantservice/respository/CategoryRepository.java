package com.samplerestaurantservice.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Category;
import com.samplerestaurantservice.entity.Menu;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByMenu(Menu menu);

}
