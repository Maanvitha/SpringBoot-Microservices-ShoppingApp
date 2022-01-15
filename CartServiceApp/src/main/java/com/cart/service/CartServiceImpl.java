package com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.Cart;
import com.cart.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService{

	
	@Autowired 
	CartRepo repo;
	@Override
	public Cart getcart(int uid) {
		return repo.getById(uid);
	}

	@Override
	public String deletecart(int cartId) {
		repo.deleteById(cartId);
		return "Deleted";
	}

	@Override
	public Cart updatecart(int cartId, Cart cart) {
		Cart q=repo.getById(cartId);
		q.setItems(cart.getItems());
		repo.save(q);
		return q;
		
	}

	@Override
	public Cart createcart(Cart cart) {
		return repo.save(cart);
	}

}
