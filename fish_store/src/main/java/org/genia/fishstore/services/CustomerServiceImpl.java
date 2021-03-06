package org.genia.fishstore.services;

import javax.inject.Inject;

import org.genia.fishstore.dao.CustomerDao;
import org.genia.fishstore.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService {
	@Inject
	private CustomerDao dao;
	
	@Inject
	public CustomerServiceImpl(CustomerDao dao) {
		super(dao, Customer.class);
	}

	@Override
	public Customer findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public void setPrepayment(int customerId, int prepayment) {
		dao.findById(customerId).setPrepaymentRights(prepayment);
	}
}
