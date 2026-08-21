package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Customer;
import com.example.restfulapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        Customer customer = service.findById(id);
        return customer == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customer));
    }
}
