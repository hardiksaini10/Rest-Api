package com.example.blackcoffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blackcoffer.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
