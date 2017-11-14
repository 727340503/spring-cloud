package com.rahul.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.cloud.entity.User;
import com.rahul.cloud.hystrix.UserFeignClientHystrix;

@FeignClient(name="microservice-provider-user",fallback=UserFeignClientHystrix.class)
public interface UserFeignClient {

	@RequestMapping(method=RequestMethod.GET, value = "/simple/{id}")
	public User findById(@PathVariable("id")Long id);

	@RequestMapping(method=RequestMethod.POST,value="/postUser")
	public User postUser(@RequestParam("id") Long id);
	
	
}
