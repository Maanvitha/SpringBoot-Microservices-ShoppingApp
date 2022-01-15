package com.composite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.composite.model.CustomerOrders;
@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrders,Integer> {

	List<CustomerOrders> findByCustomerId(int customerId);

}
