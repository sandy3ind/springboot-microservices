package com.springbootorganizationservice.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootorganizationservice.model.Department;

import feign.FeignException;

public class DepartmentClientFallback implements DepartmentClient {
	
	private final Throwable cause;
	
	public DepartmentClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<Department> findByOrganization(Long organizationId) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            return null;
        }
		return Collections.emptyList();
	}

	@Override
	public List<Department> findByOrganizationWithEmployees(Long organizationId) {
		return Collections.emptyList();
	}

}
