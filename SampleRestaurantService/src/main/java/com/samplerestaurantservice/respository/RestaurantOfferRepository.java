package com.samplerestaurantservice.respository;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.RestaurantOffer;

public interface RestaurantOfferRepository extends CrudRepository<RestaurantOffer, Long> {

}
