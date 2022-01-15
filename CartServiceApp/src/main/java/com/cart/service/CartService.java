package com.cart.service;

import org.springframework.stereotype.Service;

import com.cart.model.Cart;

@Service
public interface CartService {

	Cart getcart(int uid);

	String deletecart(int cartId);

	Cart updatecart(int cartId, Cart cart);

	Cart createcart(Cart cart);

}
