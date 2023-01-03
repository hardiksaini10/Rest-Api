package com.example.blackcoffer.service.impl;

import org.springframework.stereotype.Service;

import com.example.blackcoffer.entity.Customer;
import com.example.blackcoffer.repository.CustomerRepository;
import com.example.blackcoffer.service.CustomerService;
import com.example.blackcoffer.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer updateCustomer(Customer customer, Integer id) {
		Customer existingCustomer= customerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "Id",id));
		
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setGender(customer.getGender());
		customerRepository.save(existingCustomer);
		
		return existingCustomer;
	}


	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
		customerRepository.deleteById(id);
		
	}

}
