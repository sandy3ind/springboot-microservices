package com.sampleuserservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sampleuserservice.entity.Device;
import com.sampleuserservice.entity.User;
import com.sampleuserservice.entity.UserVerification;

public interface UserVerificationRepository extends CrudRepository<UserVerification, Long> {

	UserVerification findByUserAndIsValid(User user, boolean isValid);


}
