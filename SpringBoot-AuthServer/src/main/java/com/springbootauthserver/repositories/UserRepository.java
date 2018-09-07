package com.springbootauthserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootauthserver.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);

}
