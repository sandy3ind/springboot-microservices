package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Category;
import com.samplerestaurantservice.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}
