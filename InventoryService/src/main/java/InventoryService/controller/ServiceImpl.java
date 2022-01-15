package InventoryService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import InventoryService.model.ProductInventory;

@Service
public class ServiceImpl implements InvService{

	
	@Autowired
	InventoryRepository repo;
	
	public ProductInventory updateInv(int id, ProductInventory i) {
		
		Optional<ProductInventory> p=repo.findById(id);
		ProductInventory q=p.get();
		q.setQuantity(i.getQuantity());
		repo.save(q);
		return q;
	}

	public ProductInventory getInv(int id) {

		return repo.getById(id);
	}


	public ProductInventory addInv(ProductInventory a) {
		repo.save(a);
		return a;
	}

	public String deleteInv(int id) {
		repo.deleteById(id);
		return "Deleted";
	}

	public ProductInventory getInventoryByPid(int pid) {
		return repo.findByProductId(pid);
	}

	
	
	

}
