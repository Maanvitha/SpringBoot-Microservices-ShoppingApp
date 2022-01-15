package com.order.service;

import org.springframework.stereotype.Service;

import com.order.model.Order;


@Service
public interface OrderService {

	public Order createOrder(Order order) ;

	public Order getOrder(int orderId) ;

	public Order updateOrder(int orderId, Order order) ;

	public String deleteOrder(int orderId) ;
}
