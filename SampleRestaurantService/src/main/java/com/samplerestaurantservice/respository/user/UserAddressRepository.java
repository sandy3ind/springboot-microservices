package com.samplerestaurantservice.respository.user;

import org.springframework.data.repository.CrudRepository;

import com.samplerestaurantservice.entity.user.User;
import com.samplerestaurantservice.entity.user.UserAddress;
import com.samplerestaurantservice.util.Constant.AddressType;

public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

	UserAddress findByUserAndAddressType(User user, AddressType addressType);

}
