package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cusRepo;

	public Customer addCustomer(Customer customer) {
		return cusRepo.save(customer);
	}

	public void deleteCustomer(Long id) {
		cusRepo.deleteById(id);
	}

	public Customer updateCustomer(Long id, Customer customer) {

		Customer customer2 = cusRepo.getById(id);
		customer2.setCustomerName(customer.getCustomerName());
		customer2.setCustomerEmail(customer.getCustomerEmail());
		customer2.setCustomerBillingAddress(customer.getCustomerBillingAddress());
		customer2.setCustomerShippingAddress(customer.getCustomerShippingAddress());

		return cusRepo.save(customer2);
	}

	public Customer searchCustomer(Long id) {
		return cusRepo.findById(id).get();
	}


}
