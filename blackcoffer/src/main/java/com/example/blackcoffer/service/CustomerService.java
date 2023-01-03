package com.example.blackcoffer.service;

import com.example.blackcoffer.entity.Customer;

public interface CustomerService {
	
	Customer updateCustomer(Customer customer,Integer id);
	void deleteCustomer(Integer id);
}
