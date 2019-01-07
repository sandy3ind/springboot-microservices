package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Cuisine;

public interface CuisineRepository extends CrudRepository<Cuisine, Long> {

}
