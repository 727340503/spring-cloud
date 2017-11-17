package com.rahul.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.MyEurekaFeignConfig;
import com.rahul.cloud.hystrix.EurekaFeignClientHystrix;

@FeignClient(name="xxxx",url="http://127.0.0.1:8761/",configuration=MyEurekaFeignConfig.class,fallback=EurekaFeignClientHystrix.class)
public interface EurekaFeignClient {

	@RequestMapping(method=RequestMethod.GET, value = "/eureka/apps/{serviceName}")
	String findServiceInfoByServiceName(@RequestParam("serviceName") String serviceName);
	
	
}
