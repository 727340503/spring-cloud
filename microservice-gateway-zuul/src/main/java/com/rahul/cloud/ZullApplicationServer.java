package com.rahul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZullApplicationServer {

	public static void main(String[] args) {
		SpringApplication.run(ZullApplicationServer.class, args);
	}
	
}
