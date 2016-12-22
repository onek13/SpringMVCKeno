/**
 * 
 */
package com.training.customer.jdbc;

import java.util.List;

import com.training.customer.model.Customer;

/**
 * @author Keno San Pedro
 *
 */
public interface ICustomerJDBC {
	public List<Customer> getCustomerList();
}
