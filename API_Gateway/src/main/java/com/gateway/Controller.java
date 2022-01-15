package com.gateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/cartserviceFallback")
	public String cartServiceFallBack() {
		return "Cart Service is taking longer than expected, Please try again later";
	}
	
	@GetMapping("/compositeserviceFallback")
	public String compositeServiceFallBack() {
		return "Retail Service is taking longer than expected, Please try again later";
	}
	
	@GetMapping("/customerserviceFallback")
	public String customerServiceFallBack() {
		return "Customer Service is taking longer than expected, Please try again later";
	}
	
	@GetMapping("/inventoryserviceFallback")
	public String inventoryServiceFallBack() {
		return "Invetory Service is taking longer than expected, Please try again later";
	}
	
	
	
	@GetMapping("/orderserviceFallback")
	public String orderServiceFallBack() {
		return "Order Service is taking longer than expected, Please try again later";
	}
	
	@GetMapping("/productserviceFallback")
	public String productServiceFallBack() {
		return "Product Service is taking longer than expected, Please try again later";
	}
	

}
