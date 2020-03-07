package com.abc.project.zuulproject;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@SpringBootApplication
public class ZuulProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProjectApplication.class, args);
	}

}
