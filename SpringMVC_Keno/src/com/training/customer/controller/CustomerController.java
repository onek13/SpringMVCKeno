package com.training.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping(value="/listCustomer")
	public String displayListCustomer() {
		return "list_customer";
	}
	
}
