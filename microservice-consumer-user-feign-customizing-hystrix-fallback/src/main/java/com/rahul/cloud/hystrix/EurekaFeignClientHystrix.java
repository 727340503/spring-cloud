package com.rahul.cloud.hystrix;

import org.springframework.stereotype.Component;

import com.rahul.cloud.feign.EurekaFeignClient;

@Component
public class EurekaFeignClientHystrix implements EurekaFeignClient{

	@Override
	public String findServiceInfoByServiceName(String serviceName) {
		return "haha";
	}

	
}
