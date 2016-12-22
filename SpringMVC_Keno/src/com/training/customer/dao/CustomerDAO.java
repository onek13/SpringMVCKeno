/**
 * 
 */
package com.training.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.customer.model.Customer;

/**
 * @author keno san pedro
 *
 */

@Repository
public class CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Customer> getCustomerList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, new Integer(id));
		return customer;
	}

	public Customer createCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}

	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if (null != customer) {
			session.delete(customer);
		}
	}	
	
	
}
