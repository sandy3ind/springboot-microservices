package com.sampleuserservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sampleuserservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Long countByPhone(String phone);

	Long countByEmail(String email);

	User findByPhone(String phone);

}
