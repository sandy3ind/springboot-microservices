package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Cuisine;
import com.samplerestaurantservice.entity.OptionType;

public interface OptionTypeRepository extends CrudRepository<OptionType, Long> {

}
