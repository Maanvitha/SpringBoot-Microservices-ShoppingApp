package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Billingaddress;

public interface AddressRepo extends JpaRepository<Billingaddress, Long>{

}
