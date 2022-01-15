package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/Product")
public class Controller {

	
	@Autowired
	ProductService ser;
	
	@PostMapping("/create")
	public Product createProduct( @RequestBody Product p) {
		return ser.createProduct(p);
		
	}
	
	@GetMapping("/getProduct/{pid}")
	public Product getProduct(@PathVariable("pid") int pid){
		return ser.getProduct(pid);
	}
	
	@GetMapping("/productslist")
	public List<Product> getProducts() {
		return ser.getProducts();
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid) {
		return ser.deleteProduct(pid);
	}
	
	
	@PutMapping("/update/{pid}")
	public Product updateProduct(@PathVariable("pid") int pid, @RequestBody Product a) {
		return ser.updateProduct(pid,a);
	}
	
}
