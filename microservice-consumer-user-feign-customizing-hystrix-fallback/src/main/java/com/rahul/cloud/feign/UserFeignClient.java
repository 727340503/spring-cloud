package com.rahul.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.config.MyFeignConfig;
import com.rahul.cloud.entity.User;
import com.rahul.cloud.hystrix.FallbackUserFeignClientHystrix;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-provider-user",configuration=MyFeignConfig.class, /**fallback=UserFeignClientHystrix.class**/ fallbackFactory=FallbackUserFeignClientHystrix.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
	@RequestLine("POST /postUser")
	public User postUser(@Param("id") Long id);
}
