package com.rahul.cloud.hystrix;

import org.springframework.stereotype.Component;

import com.rahul.cloud.entity.User;
import com.rahul.cloud.feign.UserFeignClient;

@Component
public class UserFeignClientHystrix implements UserFeignClient{

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}

	@Override
	public User postUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
