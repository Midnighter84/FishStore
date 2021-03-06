package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.EmployeeDao;
import org.genia.fishstore.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements
		EmployeeService {
	
	private EmployeeDao dao;
	
	@Inject
	public EmployeeServiceImpl(EmployeeDao dao) {
		super(dao, Employee.class);
		this.dao = dao;
	}
	
	@Override
	public Employee findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public void suspendById(int id) {
		dao.findById(id).setSuspended(true);
	}

	@Override
	public void unSuspendById(int id) {
		dao.findById(id).setSuspended(false);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return dao.findAll();
	}
}
