package InventoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import InventoryService.model.ProductInventory;

@RestController
@RequestMapping("/Inventory")
public class Controller {
	
	
	
	@Autowired(required=true)
	ServiceImpl invService;
	
	@GetMapping("/sample")
	public String sample() 
	{
		return "sample";
	}
	
	
	@PostMapping("/api/inventory")
	public  ProductInventory addInventory(@RequestBody ProductInventory a) {
		return invService.addInv(a);
		 
	}
	@GetMapping("/api/inventory/{id}")
	public ProductInventory getInventory(@PathVariable(value="id") int id)
	{
		return invService.getInv(id);
		
	}
	
	@PutMapping("/api/inventory/{id}")
	public ProductInventory updateInventory(@PathVariable(value="id") int id, @RequestBody ProductInventory p)
	{
		return invService.updateInv(id,p);
		
	}
	
	@DeleteMapping("/api/inventory/{id}")
	public String deleteInventory(@PathVariable(value="id") int id)
	{
		return invService.deleteInv(id);
	}
	
	@GetMapping("/getinventorybyproduct/{pid}")
	public ProductInventory getInventorybyPid(@PathVariable("pid") int pid){
		return invService.getInventoryByPid(pid);
	}
	

}
