package com.abc.loginservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.loginservice.dao.BuyerSignupDao;
import com.abc.loginservice.entity.BillDetailsEntity;
import com.abc.loginservice.entity.BillEntity;
import com.abc.loginservice.entity.BuyerSignupEntity;
import com.abc.loginservice.entity.CategoryEntity;
import com.abc.loginservice.entity.ItemEntity;
import com.abc.loginservice.entity.SellerSignupEntity;
import com.abc.loginservice.entity.SubCategoryEntity;
import com.abc.loginservice.pojo.BillDetailsPojo;
import com.abc.loginservice.pojo.BillPojo;
import com.abc.loginservice.pojo.BuyerSignupPojo;
import com.abc.loginservice.pojo.CategoryPojo;
import com.abc.loginservice.pojo.ItemPojo;
import com.abc.loginservice.pojo.SellerSignupPojo;
import com.abc.loginservice.pojo.SubCategoryPojo;
import com.sun.istack.logging.Logger;

@Service
public class BuyerSignupServiceImpl implements BuyerSignupService{

	static Logger LOG = Logger.getLogger(BuyerSignupServiceImpl.class.getClass());	


	@Autowired
	BuyerSignupDao buyerDao;
	@Override
	public BuyerSignupPojo validateBuyersignup(BuyerSignupPojo buyerSignupPojo) {
		LOG.info("entered validateBuyerSignup()");
		System.out.println("username:" + buyerSignupPojo.getUsername());
		System.out.println("password:" + buyerSignupPojo.getPassword());
		BuyerSignupEntity buyerSignupEntity = buyerDao.findByUsernameAndPassword(buyerSignupPojo.getUsername(),
				buyerSignupPojo.getPassword());
		System.out.println(buyerSignupEntity);
		if (buyerSignupEntity != null) {
			
			Set<BillEntity> allBillsEntity = buyerSignupEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
			
			
			for (BillEntity billEntity : allBillsEntity) {
				
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();
				
				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					
					ItemEntity itemEntity = billDetailsEntity.getItemId();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
					CategoryEntity categoryEntity = subCategoryEntity.getCategory();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();
					CategoryPojo categoryPojo = new CategoryPojo(
																categoryEntity.getId(), 
																categoryEntity.getName(),
																categoryEntity.getBrief()
																);
					SubCategoryPojo subCategoryPojo = new SubCategoryPojo(
																subCategoryEntity.getId(),
																subCategoryEntity.getName(), 
																subCategoryEntity.getBrief(),
																subCategoryEntity.getGstPercent(),
																categoryPojo
																);
					SellerSignupPojo sellerPojo = new SellerSignupPojo(
																sellerSignupEntity.getId(),
																sellerSignupEntity.getUsername(), 
																sellerSignupEntity.getPassword(),
																sellerSignupEntity.getCompany(), 
																sellerSignupEntity.getBrief(), 
																sellerSignupEntity.getGst(),
																sellerSignupEntity.getAddress(), 
																sellerSignupEntity.getEmail(),
																sellerSignupEntity.getWebsite(), 
																sellerSignupEntity.getContact()
																);
					ItemPojo itemPojo = new ItemPojo(
														itemEntity.getId(), 
														itemEntity.getName(),
														itemEntity.getImage(),
														itemEntity.getPrice(), 
														itemEntity.getStock(), 
														itemEntity.getDescription(),
														itemEntity.getRemarks(),
														sellerPojo, 
														subCategoryPojo
														);
					BillDetailsPojo billDetailsPojo = new BillDetailsPojo(
																			billDetailsEntity.getId(),
																			null, 
																			itemPojo	
																			);
					allBillDetailsPojo.add(billDetailsPojo);
				}
					BillPojo billPojo = new BillPojo(
														billEntity.getId(),
														null,
														billEntity.getType(),
														billEntity.getDate(),
														billEntity.getRemarks(),
														billEntity.getAmount(),
														allBillDetailsPojo
														);
					allBillPojo.add(billPojo);
			}
					buyerSignupPojo = new BuyerSignupPojo(
															buyerSignupEntity.getId(),
															buyerSignupEntity.getUsername(),
															buyerSignupEntity.getPassword(), 
															buyerSignupEntity.getEmail(),
															buyerSignupEntity.getMobile(),
															buyerSignupEntity.getDate(),
															allBillPojo
															);

				}
		LOG.info("exited validateBuyerSignup()");
		return buyerSignupPojo;
		
	}

	@Override
	public BuyerSignupPojo getBuyer(int buyerId) {
		LOG.info("entered getBuyer()");
		BuyerSignupPojo buyerSignupPojo=null;
		BuyerSignupEntity buyerSignupEntity = buyerDao.findById(buyerId).get();
		System.out.println("get buyer:"+buyerSignupEntity);
		if (buyerSignupEntity != null) {
			
			Set<BillEntity> allBillsEntity = buyerSignupEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
			
			for (BillEntity billEntity : allBillsEntity) {
				
				
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();
				
				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					
					ItemEntity itemEntity = billDetailsEntity.getItemId();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
					CategoryEntity categoryEntity = subCategoryEntity.getCategory();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();
					CategoryPojo categoryPojo = new CategoryPojo(
																categoryEntity.getId(), 
																categoryEntity.getName(),
																categoryEntity.getBrief()
																);
					SubCategoryPojo subCategoryPojo = new SubCategoryPojo(
																subCategoryEntity.getId(),
																subCategoryEntity.getName(), 
																subCategoryEntity.getBrief(),
																subCategoryEntity.getGstPercent(),
																categoryPojo
																);
					SellerSignupPojo sellerPojo = new SellerSignupPojo(
																sellerSignupEntity.getId(),
																sellerSignupEntity.getUsername(), 
																sellerSignupEntity.getPassword(),
																sellerSignupEntity.getCompany(), 
																sellerSignupEntity.getBrief(), 
																sellerSignupEntity.getGst(),
																sellerSignupEntity.getAddress(), 
																sellerSignupEntity.getEmail(),
																sellerSignupEntity.getWebsite(), 
																sellerSignupEntity.getContact()
																);
					ItemPojo itemPojo = new ItemPojo(
														itemEntity.getId(), 
														itemEntity.getName(),
														itemEntity.getImage(),
														itemEntity.getPrice(), 
														itemEntity.getStock(), 
														itemEntity.getDescription(),
														itemEntity.getRemarks(),
														sellerPojo, 
														subCategoryPojo
														);
					BillDetailsPojo billDetailsPojo = new BillDetailsPojo(
																			billDetailsEntity.getId(),
																			null, 
																			itemPojo	
																			);
					allBillDetailsPojo.add(billDetailsPojo);
				}
					BillPojo billPojo = new BillPojo(
														billEntity.getId(),
														null,
														billEntity.getType(),
														billEntity.getDate(),
														billEntity.getRemarks(),
														billEntity.getAmount(),
														allBillDetailsPojo
														);
					allBillPojo.add(billPojo);
			}
					buyerSignupPojo = new BuyerSignupPojo(
															buyerSignupEntity.getId(),
															buyerSignupEntity.getUsername(),
															buyerSignupEntity.getPassword(), 
															buyerSignupEntity.getEmail(),
															buyerSignupEntity.getMobile(),
															buyerSignupEntity.getDate(),
															allBillPojo
															);

				}
		LOG.info("exited getBuyer()");
		return buyerSignupPojo;

		
	}
}
	

		
		
