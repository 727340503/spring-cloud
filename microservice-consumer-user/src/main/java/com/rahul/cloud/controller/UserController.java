package com.rahul.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rahul.cloud.entity.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie")
	public User findById(Long id) {
		return restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	
	
}
