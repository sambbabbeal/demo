package com.example.demo.controllers;

import com.example.demo.Model.Customers;
import com.example.demo.Repos.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
@ResponseBody
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public Flux<Customers> index() {
        Flux<Customers> items = repository.findAll();
        System.out.println(items.collectList().flatMapMany(Flux::just));
        return items;
    }
    /*
     * @PostMapping
     * 
     * @ResponseStatus(code = HttpStatus.CREATED)
     * public Mono<String> save(@RequestBody Customers customer) {
     * return repository.save(customer).map(g -> "Saved: ");
     * }
     * 
     * @GetMapping(value = "/{id}", produces = "application/json")
     * public Mono<Customers> get(@PathVariable("id") String id) {
     * return repository.findById(id);
     * }
     * 
     * @GetMapping(produces = "application/json")
     * public Flux<Customers> get() {
     * return repository.findAll();
     * }
     * 
     * @PutMapping(value = "/{id}", produces = "application/json")
     * public Mono<Customers> update(@PathVariable("id") long id, @RequestBody
     * Customers customer) {
     * repository.save(customer);
     * return Mono.just(customer);
     * }
     * 
     * @DeleteMapping(value = "/{id}", produces = "application/json")
     * public Mono<Customers> delete(@PathVariable("id") String id) {
     * return repository.findById(id);
     * }
     */

}
