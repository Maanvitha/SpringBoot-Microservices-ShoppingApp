package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepo repo;
	
	@Override
	public Product createProduct(Product p) {
		return repo.save(p);
	}

	@Override
	public Product getProduct(int pid) {
	 return repo.getById(pid);
	}

	@Override
	public List<Product> getProducts() {
		
		return repo.findAll();
	}

	@Override
	public String deleteProduct(int pid) {
		repo.deleteById(pid);
		return "Deleted";
	}

	@Override
	public Product updateProduct(int pid, Product a) {
		Product q= repo.getById(pid);
		q.setPname(a.getPname());
		q.setDescription(a.getDescription());
		q.setPrice(a.getPrice());
		return q;
	}

}
