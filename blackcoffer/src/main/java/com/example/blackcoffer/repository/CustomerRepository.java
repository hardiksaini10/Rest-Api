package com.example.blackcoffer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.blackcoffer.dto.OrderResponse;
import com.example.blackcoffer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT new com.example.blackcoffer.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
	
	@Query("SELECT new com.example.blackcoffer.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p where c.id=:id")
    public List<OrderResponse> getProductAndCustomerDetailsById(Integer id);

}
