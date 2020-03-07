package com.abc.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.buyeritemservice.entity.BillEntity;


@Repository
public interface BillDao extends JpaRepository<BillEntity,Integer> {

}
