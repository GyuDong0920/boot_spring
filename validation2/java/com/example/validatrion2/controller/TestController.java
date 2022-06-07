package com.example.validatrion2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validatrion2.dto.User;

@RestController
@RequestMapping("/test")
public class TestController {

	
	@GetMapping("/hello")
	public String hello() {
		return "<hi>hello</h1";
	}
	
	@GetMapping("/user")
	public User user() {
		
		User user = new User();
		user.setName("홍길동");
		user.setAge(100);
		return user;
	}
}
