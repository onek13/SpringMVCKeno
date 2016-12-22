package com.training.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String getCountries(Model model) {

		List<Customer> customerList = customerService.getCustomerList();
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", customerList);
		return "customer/list_customer";
	}

	@RequestMapping(value = "/getCustomerById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String createCustomer(@ModelAttribute("customer") Customer customer) {
		if (customer.getId() == 0) {
			customerService.createCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}

		return "redirect:/getCustomerList";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getCustomerById(id));
		model.addAttribute("customerList", this.customerService.getCustomerList());
		return "customer/list_customer";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getCustomerList";

	}

}
