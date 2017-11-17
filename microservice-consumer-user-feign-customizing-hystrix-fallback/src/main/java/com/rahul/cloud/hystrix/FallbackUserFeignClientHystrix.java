package com.rahul.cloud.hystrix;

import com.rahul.cloud.feign.UserFeignClient;

import feign.hystrix.FallbackFactory;

public interface FallbackUserFeignClientHystrix extends FallbackFactory<UserFeignClient>{

}
