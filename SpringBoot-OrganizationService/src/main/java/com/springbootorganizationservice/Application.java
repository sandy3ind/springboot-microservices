package com.springbootorganizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.springbootorganizationservice.model.Organization;
import com.springbootorganizationservice.repository.OrganizationRepository;

import feign.RequestInterceptor;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	OrganizationRepository repository() {
		OrganizationRepository repository = new OrganizationRepository();
		repository.add(new Organization("Microsoft", "Redmond, Washington, USA"));
		repository.add(new Organization("Oracle", "Redwood City, California, USA"));	
		return repository;
	}
	
	@Bean
    public RequestInterceptor getFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}
