package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantOption;

public interface RestaurantOptionRepository extends CrudRepository<RestaurantOption, Long> {

}
