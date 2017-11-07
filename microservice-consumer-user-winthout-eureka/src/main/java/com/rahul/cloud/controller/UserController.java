package com.rahul.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rahul.cloud.entity.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie")
	public User findById(Long id) {
		
		return restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	
	@GetMapping("/test")
	public String test() {
		
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		System.out.println("microservice-provider-user1 - "+serviceInstance.getHost()+" : "+serviceInstance.getPort());
		
//		ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
//		System.out.println("microservice-provider-user2 - "+serviceInstance2.getHost()+" : "+serviceInstance2.getPort());
		
		return "1";
	}
	
	
}
