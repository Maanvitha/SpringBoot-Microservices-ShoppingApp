package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.service.OrderService;


@RestController
@RequestMapping("/Order")
public class Controller {
	
	@Autowired
	OrderService ser;
	
	@PostMapping("/addOrder")
	public Order createOrder(@RequestBody Order Order){
		System.out.println("In Order controller");
		return ser.createOrder(Order);
		
	}
	
	@GetMapping("/getitems/{OrderId}")
	public Order getOrder(@PathVariable ("OrderId") int OrderId){
		
		return ser.getOrder(OrderId);
		
	}
	
	@PutMapping("/updateOrder/{OrderId}")
	public Order updateOrder(@PathVariable("OrderId") int OrderId, @RequestBody Order Order ){
		return ser.updateOrder(OrderId,Order);
	}
	
	@DeleteMapping("/deleteOrder/{OrderId}")
	public String deleteOrder (@PathVariable("OrderId") int OrderId ){
		return ser.deleteOrder(OrderId);
	}
	
	@GetMapping("/getOrder/{uid}")
    public Order getAllOrders(@PathVariable int uid) {
       return ser.getOrder(uid);
    }
	


}
