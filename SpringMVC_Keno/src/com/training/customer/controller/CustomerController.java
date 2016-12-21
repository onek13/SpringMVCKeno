package com.training.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Test 2nd Commit Github

@Controller
public class CustomerController {

	@RequestMapping(value="/listCustomer")
	public String displayListCustomer() {
		return "list_customer";
	}
	
}
