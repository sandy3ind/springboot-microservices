package com.springbootdepartmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.springbootdepartmentservice.model.Department;
import com.springbootdepartmentservice.repository.DepartmentRepository;

import feign.RequestInterceptor;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(2L, "Development"));
		repository.add(new Department(2L, "Operations"));		
		return repository;
	}
	
	@Bean
    public RequestInterceptor getFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}
