package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.CustomerOrderDao;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerOrderServiceImpl extends GenericServiceImpl<CustomerOrder> implements CustomerOrderService {

	@Inject
	CustomerOrderDao dao;
	
	@Inject
	public CustomerOrderServiceImpl(CustomerOrderDao dao) {
		super(dao, CustomerOrder.class);
	}
	
	@Override
	public List<CustomerOrderItem> getOrderList(int orderId) {
		return dao.findById(orderId).getOrderItems();
	}
}
