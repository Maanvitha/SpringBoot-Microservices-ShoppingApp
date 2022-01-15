package InventoryService.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import InventoryService.model.ProductInventory;


import org.springframework.stereotype.Service;
@Service
public interface InventoryRepository extends JpaRepository<ProductInventory,Integer> 
	 {

	ProductInventory findByProductId(int pid);

}
