package com.rahul.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.cloud.entity.User;
import com.rahul.cloud.feign.EurekaFeignClient;
import com.rahul.cloud.feign.UserFeignClient;

@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private EurekaFeignClient eurekaFeignClient;
	
	@GetMapping("/user")
	public User findById(Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/postUser")
	public User postUser(Long id) {
		return userFeignClient.postUser(id);
	}
	
	@GetMapping("/{serviceName}")
	public String test(@PathVariable String serviceName) {
		return eurekaFeignClient.findServiceInfoByServiceName(serviceName);
	}
	
}
