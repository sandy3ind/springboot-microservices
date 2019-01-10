package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.Cuisine;
import com.samplerestaurantservice.entity.OfferType;

public interface OfferTypeRepository extends CrudRepository<OfferType, Long> {

}
