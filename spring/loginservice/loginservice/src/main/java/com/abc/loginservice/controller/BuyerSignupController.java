package com.abc.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.loginservice.pojo.BuyerSignupPojo;
import com.abc.loginservice.service.BuyerSignupService;

import com.sun.istack.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("emart")

public class BuyerSignupController {
	
	static Logger LOG = Logger.getLogger(BuyerSignupController.class.getClass());	

	@Autowired
	BuyerSignupService buyerService;
	@GetMapping("validate")
	BuyerSignupPojo validateBuyerSignup(@RequestHeader("Authorization") String data) {
		
		LOG.info("entered validateBuyerSignup()");
		
		String token[] = data.split(":");
		BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo();
		buyerSignupPojo.setUsername(token[0]);
		buyerSignupPojo.setPassword(token[1]);
		
		
		LOG.info("exited validateBuyerSignup()");
		return buyerService.validateBuyersignup(buyerSignupPojo);

	}
	@GetMapping("/buyer/{buyerId}")
	BuyerSignupPojo getBuyer(@PathVariable("buyerId") Integer buyerId) {
		LOG.info("entered getBuyer()");
		LOG.info("exited getBuyer()");
		return buyerService.getBuyer(buyerId);
		
		
	}


}
