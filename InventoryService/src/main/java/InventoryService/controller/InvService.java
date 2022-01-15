package InventoryService.controller;

import InventoryService.model.ProductInventory;

import org.springframework.stereotype.Service;
@Service
public interface InvService {
	
	public ProductInventory updateInv(int id, ProductInventory p);
	public ProductInventory getInv(int id);
	public ProductInventory addInv(ProductInventory a);
	public String deleteInv(int id);

}
