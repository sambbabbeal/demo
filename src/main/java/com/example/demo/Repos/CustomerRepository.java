package com.example.demo.Repos;

import com.example.demo.Model.Customers;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customers, Integer> {

}