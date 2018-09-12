package com.springbootzuulapigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController("/user")
public class UserResource {

	//@GetMapping
	public String get() {
		return "This is user";
	}
}
