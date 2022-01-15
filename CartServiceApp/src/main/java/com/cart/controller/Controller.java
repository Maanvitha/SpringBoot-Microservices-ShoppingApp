package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Cart;
import com.cart.service.CartService;

@RestController
@RequestMapping("/Cart")
public class Controller {
	
	@Autowired
	CartService ser;
	
	@PostMapping("/addcart")
	public Cart createcart(@RequestBody Cart cart){
		return ser.createcart(cart);
		
	}
	
	@GetMapping("/getitems/{cartId}")
	public Cart getcart(@PathVariable ("cartId") int cartId){
		
		return ser.getcart(cartId);
		
	}
	
	@PutMapping("/updatecart/{cartId}")
	public Cart updatecart(@PathVariable("cartId") int cartId, @RequestBody Cart cart ){
		return ser.updatecart(cartId,cart);
	}
	
	@DeleteMapping("/deletecart/{cartId}")
	public String deletecart (@PathVariable("cartId") int cartId ){
		return ser.deletecart(cartId);
	}
	
	@GetMapping("/getCart/{uid}")
    public Cart getAllOrders(@PathVariable int uid) {
       return ser.getcart(uid);
    }
	

}
