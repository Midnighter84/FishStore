package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderService {
	public void removeOrderById(int id);
	public void updateOrderList(List<CompanyOrderItem> items);
	public List<CustomerOrderItem> getOrderDetails();
	public void removeItemById(int id);
}