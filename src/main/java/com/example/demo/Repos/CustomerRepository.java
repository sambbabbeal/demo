package com.example.demo.Repos;

import com.example.demo.Model.Customers;

import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customers, String> {
    Flux<Customers> findByName(String name);

    Mono<Customers> findById(@Param("id") Integer id);

    Mono<Customers> update(@PathVariable("id") Integer id, @RequestBody Customers customer);

    Mono<Customers> delete(@PathVariable("id") Integer id);

}
