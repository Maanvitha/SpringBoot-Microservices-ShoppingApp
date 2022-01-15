package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Product;

@Service
public interface ProductService {

	Product createProduct(Product p);

	Product getProduct(int pid);

	List<Product> getProducts();

	String deleteProduct(int pid);

	Product updateProduct(int pid, Product a);

}
