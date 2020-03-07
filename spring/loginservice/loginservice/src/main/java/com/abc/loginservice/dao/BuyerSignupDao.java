package com.abc.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.loginservice.entity.BuyerSignupEntity;


@Repository
public interface BuyerSignupDao extends JpaRepository<BuyerSignupEntity,Integer> {

		BuyerSignupEntity findByUsernameAndPassword(String username,String password);
}
