package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Cuisine;
import com.samplerestaurantservice.entity.OptionType;
import com.samplerestaurantservice.entity.RestaurantOptionType;

public interface RestaurantOptionTypeRepository extends CrudRepository<RestaurantOptionType, Long> {

}
