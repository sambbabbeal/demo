package com.example.demo.Repos;

import com.example.demo.Model.Customers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomRepositoryImpl implements CustomerRepositoryCustom {

    @Override
    public Flux<Customers> findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Customers> findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Void> delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Customers> update(Integer id, Customers customer) {
        // TODO Auto-generated method stub
        return null;
    }

}
