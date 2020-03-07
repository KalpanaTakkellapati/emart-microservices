package com.abc.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.buyeritemservice.entity.ItemEntity;



@Repository
public interface ItemDao extends JpaRepository<ItemEntity,Integer> {

}
