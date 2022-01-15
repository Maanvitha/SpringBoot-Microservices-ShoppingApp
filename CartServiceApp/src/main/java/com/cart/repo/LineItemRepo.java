package com.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem,Integer>{

}
