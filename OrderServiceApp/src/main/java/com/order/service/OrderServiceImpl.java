package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Order;
import com.order.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderRepo repo;
	
	@Override
	public Order createOrder(Order order) {
		System.out.println("In order service impl");
		return repo.save(order);
	}

	@Override
	public Order getOrder(int orderId) {
		return repo.getById(orderId);
	}

	@Override
	public Order updateOrder(int orderId, Order order) {
		Order o=repo.getById(orderId);
		o.setItems(order.getItems());
		repo.save(o);
		return o;
	}

	@Override
	public String deleteOrder(int orderId) {
		 repo.deleteById(orderId);
		 return "Deleted";
			
	}

}
