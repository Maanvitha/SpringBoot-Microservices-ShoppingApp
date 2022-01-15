package com.composite.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.composite.model.Cart;
import com.composite.model.Customer;
import com.composite.model.CustomerCart;
import com.composite.model.CustomerOrderres;
import com.composite.model.CustomerOrders;
import com.composite.model.Inventory;
import com.composite.model.LineItem;
import com.composite.model.Order;
import com.composite.model.OrderItems;
import com.composite.model.Product;
import com.composite.model.ProductInput;
import com.composite.model.ProductInventory;
import com.composite.repository.CustomerCartRepo;
import com.composite.repository.CustomerOrderRepo;
import com.composite.service.CompositeService;

@RestController
@RequestMapping("/RetailStore")
public class Controller {

	
	@Autowired
	RestTemplate restTemplate;

	//@Autowired
	//EurekaClient eurekaClient;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	CompositeService cservice;
	@Autowired
	CustomerCartRepo crepo;
	
	@Autowired
	CustomerOrderRepo orepo;


	

	
	@PostMapping("/products")
	public ResponseEntity<?> productandinventory(@RequestBody ProductInput p) {
		
		
		
		//create product
		//create inventory
		//combine both and return
		System.out.println("Inside method");
		Product product=restTemplate.postForObject("http://PRODUCT-SERVICE/Product/create", p, Product.class);
		System.out.println(product.toString());
		
		Inventory inventory=new Inventory();
		inventory.setProductId(product.getPid());
		inventory.setQuantity(p.getQuantity());
		ResponseEntity<Inventory> inv=restTemplate.postForEntity("http://INVENTORY-SERVICE/Inventory/api/inventory", inventory, Inventory.class);
		ProductInventory pi=new ProductInventory();
		pi.setI(inv.getBody());
		pi.setP(product);
		return new ResponseEntity<ProductInventory>(pi,HttpStatus.CREATED);
		
		
	}

	

	@PostMapping("/customer")
	public ResponseEntity<?> customerandcart(@RequestBody Customer c) {
		
		//create customer
		//create cart
		//maintain mapping
		
		ResponseEntity<Customer> customer=restTemplate.postForEntity("http://CUSTOMER-SERVICE/Customer/api/addCustomer", c, Customer.class);
		Cart crt=new Cart();
		ResponseEntity<Cart> cart=restTemplate.postForEntity("http://CART-SERVICE/Cart/addcart", crt, Cart.class);
		CustomerCart cusCar=new CustomerCart();
		cusCar.setCartId(cart.getBody().getCartId());
		cusCar.setCustomerId(customer.getBody().getCustomerId());
		cservice.CustomerCartMapping(cusCar);
		return new ResponseEntity<CustomerCart>(cusCar, HttpStatus.CREATED);
		
	
	}

	@PutMapping("/additemstocart/{customerId}")
	public ResponseEntity<?> addcartitems(@PathVariable(value="customerId") int customerId, @RequestBody Cart c) {
		
		
		System.out.println("Inside method");
		CustomerCart cc=crepo.findByCustomerId(customerId);
		if(cc==null)
			return new ResponseEntity<String>("No Customer Exist with that id",HttpStatus.NOT_FOUND);
		int cartId=cc.getCartId();
		restTemplate.put("http://CART-SERVICE/updatecart/"+cartId, c);
		ResponseEntity<Cart> cartc=restTemplate.getForEntity("http://CART-SERVICE/Cart/getitems/"+cartId, Cart.class);
		return new ResponseEntity<Cart>(cartc.getBody(), HttpStatus.CREATED);
		
		
		
		
	}

	@PostMapping("/customerOrder/{customerId}")
	public ResponseEntity<?> placeorder(@PathVariable(value="customerId") int customerId) {
		
		//check customer exists
		//cart-order
		//remove cart
		//update inventory
		//maintain mapping
		System.out.println("1st line");
		CustomerCart cc=crepo.findByCustomerId(customerId);
		if(cc==null)
			return new ResponseEntity<String>("No Customer Exist with that id",HttpStatus.NOT_FOUND);
		int cartId=cc.getCartId();
		ResponseEntity<Cart> cartc=restTemplate.getForEntity("http://CART-SERVICE/Cart/getitems/"+cartId, Cart.class);
		System.out.println("got cart");
		//List<LineItem> item=cartc.getBody().getItems();
		//List<OrderItems> orderItems=item;
		
		
		List<OrderItems> items=new ArrayList<OrderItems>();
		for (LineItem i : cartc.getBody().getItems()) {
			items.add(new OrderItems(i.getProductId(),i.getProductName(),i.getQuantity(),i.getPrice()));
		}
		
		
		
		Order o=new Order();
		o.setItems(items);
		Order o1=new Order(o);
		System.out.println("set order with cart items");
		ResponseEntity<Order> order=restTemplate.postForEntity("http://ORDER-SERVICE/Order/addOrder",o1,Order.class);
		System.out.println("created order");
		CustomerOrders co = new CustomerOrders();
		co.setCustomerId(customerId);
		//List<Integer> orderno=new ArrayList<Integer>();
		//orderno.add(order.getBody().getOrderId());
		co.setOrderId(order.getBody().getOrderId());
		cservice.createOrder(co);
		Cart emptycart = new Cart();
		restTemplate.put("localhost:8009/updatecart/" + cartId, emptycart);
		for (OrderItems i : order.getBody().getItems()) {
			int p = i.getProductId();
			int q = i.getQuantity();
			Inventory inv = restTemplate.getForObject("http://INVENTORY-SERVICE/Inventory/getinventorybyproduct/"+ p, Inventory.class);
			Map<String, Integer> ibody = new HashMap<String, Integer>();
			ibody.put("productId", p);
			ibody.put("quantity", inv.getQuantity() - q);
			restTemplate.put("9098/api/inventory/" + inv.getInventoryId(), ibody);
		}
		return new ResponseEntity<Order>(order.getBody(), HttpStatus.CREATED);
		
		
		
	}

//	// 5th part ->getOrders
	@GetMapping("/Orders/{customerId}")
	public ResponseEntity<?> getorders(@PathVariable("customerId") int customerId) {
		
		
		List<Order> olist = new ArrayList<Order>();
		List<CustomerOrders> l = cservice.findorders(customerId);
		if (l == null)
			return new ResponseEntity<String>("no orders for this customer", HttpStatus.CREATED);
		Customer c = restTemplate.getForObject("http://CUSTOMER-SERVICE/Customer/api/searchCustomer/" + customerId, Customer.class);
		for (CustomerOrders cusOrder : l) {
			int i = cusOrder.getOrderId();
			Order o = restTemplate.getForObject("http://ORDER-SERVICE/Order/getitems/"+i, Order.class);
			olist.add(o);
		}
		CustomerOrderres response = new CustomerOrderres();
		response.setCustomer(c);
		response.setOds(olist);
		return new ResponseEntity<CustomerOrderres>(response, HttpStatus.CREATED);

	}

	
	
	
}
