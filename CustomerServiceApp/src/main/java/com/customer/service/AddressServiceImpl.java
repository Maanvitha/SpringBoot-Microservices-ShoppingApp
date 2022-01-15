package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Billingaddress;
import com.customer.repository.AddressRepo;



@Service
public class AddressServiceImpl implements AdressService {

	@Autowired
	private AddressRepo addRepo;
	
	public Billingaddress addCustomerAddress(Billingaddress address) {
		return addRepo.save(address);
	}

	public void deleteCustomerAddress(Long id) {
		addRepo.deleteById(id);
	}

	public Billingaddress updateCustomerAddress(Long id, Billingaddress address) {

		Billingaddress address2 = addRepo.getById(id);
		address2.setDoorNo(address.getDoorNo());
		address2.setStreetName(address.getStreetName());
		address2.setLayout(address.getLayout());
		address2.setCity(address.getCity());
		address2.setPincode(address.getPincode());
		
		return addRepo.save(address2);
	}

	public Billingaddress searchCustomerAddress(Long id) {
		return addRepo.getById(id);
	}

}
