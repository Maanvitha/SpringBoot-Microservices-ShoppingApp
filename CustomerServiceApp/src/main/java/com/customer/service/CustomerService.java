package com.customer.service;

import com.customer.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	void deleteCustomer(Long id);

	Customer updateCustomer(Long id, Customer customer);

	Customer searchCustomer(Long id);

}
