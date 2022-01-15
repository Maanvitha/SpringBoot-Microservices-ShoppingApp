package com.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}
