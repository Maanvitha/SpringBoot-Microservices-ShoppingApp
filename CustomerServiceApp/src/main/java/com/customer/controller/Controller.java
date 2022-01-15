package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class Controller {

	@Autowired
	private CustomerService cusService;

	@PostMapping("/api/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return cusService.addCustomer(customer);
	}

	@DeleteMapping("/api/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		cusService.deleteCustomer(id);
	}

	@PutMapping("/api/updateCustomer/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		return cusService.updateCustomer(id, customer);
	}

	@GetMapping("/api/searchCustomer/{id}")
	public Customer searchCustomer(@PathVariable("id") Long id) {
		return cusService.searchCustomer(id);
	}
	
}
