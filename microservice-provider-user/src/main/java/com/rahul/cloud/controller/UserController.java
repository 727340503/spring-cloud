package com.rahul.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.rahul.cloud.entity.User;
import com.rahul.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable final Long id){
		
		return userRepository.findOne(id);
	}
	
	/**
	 * 根据application name获取访问url
	 * @return
	 */
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo info = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
		return info.getHomePageUrl();
	}
	
	/**
	 * 获取本地服务器的实例信息
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		return serviceInstance;
	}
	
	@PostMapping("/postUser")
	public User postUser(Long id) {
		return userRepository.findOne(id);
	}
	
	@GetMapping("userList")
	public List<User> listUser(){
		
		List<User> list = new ArrayList<User>();
		User user = new User(1L, "zhangsan");
		User user2 = new User(2L, "liso");
		User user3 = new User(3L, "wangsu");
		list.add(user);
		list.add(user2);
		list.add(user3);
		
		return list;
	}
	
}
