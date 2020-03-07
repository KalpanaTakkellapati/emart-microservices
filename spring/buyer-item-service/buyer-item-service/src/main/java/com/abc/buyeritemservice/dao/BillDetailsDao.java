package com.abc.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.buyeritemservice.entity.BillDetailsEntity;



@Repository
public interface BillDetailsDao extends JpaRepository<BillDetailsEntity,Integer> {

}
