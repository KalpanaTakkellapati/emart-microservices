package com.abc.loginservice.service;

import com.abc.loginservice.pojo.BuyerSignupPojo;

public interface BuyerSignupService {
	BuyerSignupPojo validateBuyersignup(BuyerSignupPojo buyerSignupPojo);
	BuyerSignupPojo getBuyer(int buyerId);
}
