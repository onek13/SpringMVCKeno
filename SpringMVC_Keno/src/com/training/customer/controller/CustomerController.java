package com.training.customer.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.customer.model.Customer;
import com.training.customer.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getCustomerList", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCustomerList(Model model) {

		List<Customer> customerList = customerService.getCustomerList();
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", customerList);
		return "customer/list_customer";
	}

	@RequestMapping(value = "/getCustomerById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(value = "/prepareCreateCustomer", method = RequestMethod.GET, headers = "Accept=application/json")
	public String prepareCreateCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/customer_details";
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String createCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "customer/customer_details";
		} else if (customer.getId() == 0) {
			if (customerService.isDuplicateRecord("id_number", customer.getIdNumber(), null)) {
				model.addAttribute("duplicateIdNumberError", "Duplicate ID number");
				return "customer/customer_details";
			} else {
				customer.setLastUpdateDate(new Date());
				customerService.createCustomer(customer);	
			}			
		} else {
			customer.setLastUpdateDate(new Date());
			customerService.updateCustomer(customer);
		}

		return "customer/confirmation_message";
	}
	
	@RequestMapping(value = "/prepareUpdateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String prepareUpdateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getCustomerById(id));
		return "customer/customer_details";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getCustomerList";

	}

}
