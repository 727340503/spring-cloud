package com.rahul.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.cloud.entity.User;
import com.rahul.cloud.feign.UserFeignClient;

@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/user")
	public User findById(Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/postUser")
	public User postUser(Long id) {
		return userFeignClient.postUser(id);
	}
	
}
