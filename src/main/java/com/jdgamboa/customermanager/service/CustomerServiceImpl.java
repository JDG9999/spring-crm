package com.jdgamboa.customermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdgamboa.customermanager.dao.CustomerDAO;
import com.jdgamboa.customermanager.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

}
