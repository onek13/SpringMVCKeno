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
	
	public boolean isDuplicateRecord(String columnName, String value, Integer id);
	
	public List<Customer> getCustomerList();
	
}
