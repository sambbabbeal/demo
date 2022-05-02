package com.example.demo.controllers;

import com.example.demo.Model.Customers;
import com.example.demo.Repos.CustomerRepository;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@ResponseBody
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<String> save(@RequestBody Customers customer) {
        return repository.save(customer).map(g -> "Saved: ");
    }

    @GetMapping(value = "/{id}")
    public Mono<ResponseEntity<Customers>> get(@PathVariable(value = "id") Integer id) {
        Mono<Customers> user = repository.findById(id);

        System.out.println("hey" + id + user);
        return user.map(u -> ResponseEntity.ok(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(produces = "application/json")
    public Flux<Customers> get() {
        return repository.findAll();
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Mono<Customers> update(@PathVariable("id") Integer id, @RequestBody Customers customer) {
        repository.save(customer);
        return Mono.just(customer);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Mono<Customers> delete(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

}
