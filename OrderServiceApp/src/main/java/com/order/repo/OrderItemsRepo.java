package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.OrderItems;

public interface OrderItemsRepo extends JpaRepository<OrderItems,Integer> {

}
