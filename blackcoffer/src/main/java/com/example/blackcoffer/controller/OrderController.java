package com.example.blackcoffer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blackcoffer.dto.OrderRequest;
import com.example.blackcoffer.dto.OrderResponse;
import com.example.blackcoffer.entity.Customer;
import com.example.blackcoffer.repository.CustomerRepository;
import com.example.blackcoffer.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class OrderController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	@GetMapping("/findOrder/{id}")
	public List<OrderResponse> findOrderById(@PathVariable("id") Integer id){
		return customerRepository.getProductAndCustomerDetailsById(id);
	}
	
	@GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id ,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
	}
}
