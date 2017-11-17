package com.rahul.cloud.hystrix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rahul.cloud.entity.User;
import com.rahul.cloud.feign.UserFeignClient;

@Component
public class FallbackUserFeignClientHystrixImpl implements FallbackUserFeignClientHystrix{

	Logger log = LoggerFactory.getLogger(FallbackUserFeignClientHystrixImpl.class);
	
	@Override
	public UserFeignClient create(Throwable arg) {
		
		System.out.println("error------"+arg.getMessage());
		
		return new UserFeignClient() {
			
			@Override
			public User postUser(Long id) {
				return null;
			}
			
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}

}
