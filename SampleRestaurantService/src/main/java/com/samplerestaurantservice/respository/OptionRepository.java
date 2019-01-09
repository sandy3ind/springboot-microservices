package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
