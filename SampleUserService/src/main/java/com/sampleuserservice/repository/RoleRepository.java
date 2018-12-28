package com.sampleuserservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sampleuserservice.entity.Role;
import com.sampleuserservice.util.Constant.RoleType;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByRole(RoleType role);
}
