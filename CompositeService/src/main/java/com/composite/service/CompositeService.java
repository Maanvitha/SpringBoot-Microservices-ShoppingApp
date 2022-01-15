package com.composite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.composite.model.CustomerCart;
import com.composite.model.CustomerOrders;
import com.composite.repository.CustomerCartRepo;
import com.composite.repository.CustomerOrderRepo;

@Service
public class CompositeService {
	
	@Autowired
	CustomerCartRepo CuCaRepo;
	
	@Autowired
	CustomerOrderRepo co;

	public void CustomerCartMapping(CustomerCart cusCar) {

		CuCaRepo.save(cusCar);
	}

	public void createOrder(CustomerOrders cos) {
		co.save(cos);
	}

	public List<CustomerOrders> findorders(int customerId) {
		return co.findByCustomerId(customerId);
	}

}
