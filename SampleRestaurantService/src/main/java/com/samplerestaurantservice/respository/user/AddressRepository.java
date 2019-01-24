package com.samplerestaurantservice.respository.user;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.user.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
