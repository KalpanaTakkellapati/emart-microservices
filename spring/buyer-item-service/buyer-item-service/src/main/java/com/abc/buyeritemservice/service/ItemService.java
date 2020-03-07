package com.abc.buyeritemservice.service;

import java.util.List;

import com.abc.buyeritemservice.pojo.ItemPojo;




public interface ItemService {

	ItemPojo getItem(int itemId);
	List<ItemPojo>getAllItems();
	void deleteItem(Integer itemId);
	ItemPojo addItem(ItemPojo itemPojo);
	ItemPojo updateItem(ItemPojo itemPojo);
}
