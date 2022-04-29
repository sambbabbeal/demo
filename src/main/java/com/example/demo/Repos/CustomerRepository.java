package com.example.demo.Repos;

import com.example.demo.Model.Customers;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customers, String> {
    Flux<Customers> findByName(String name);
}
