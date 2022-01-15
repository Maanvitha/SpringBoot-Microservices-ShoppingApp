package com.composite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.composite.model.CustomerCart;

public interface CustomerCartRepo extends JpaRepository<CustomerCart,Integer>{

	CustomerCart findByCustomerId(int customerId);

}
