package com.springbootorganizationservice.client;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class DepartmentClientFallbackFactory implements FallbackFactory<DepartmentClient> {

	@Override
	public DepartmentClient create(Throwable throwable) {		
		return new DepartmentClientFallback(throwable);
	}

}
