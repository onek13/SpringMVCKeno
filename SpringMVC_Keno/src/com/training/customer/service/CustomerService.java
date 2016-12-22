package com.training.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.customer.dao.CustomerDAO;
import com.training.customer.model.Customer;

@Service("customerService")
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
		
	@Transactional
	public List<Customer> getCustomerList() {
		return customerDAO.getCustomerList();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}

	@Transactional
	public void createCustomer(Customer country) {
		customerDAO.createCustomer(country);
	}

	@Transactional
	public void updateCustomer(Customer country) {
		customerDAO.updateCustomer(country);

	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
}
