package com.example.restfulapi.service;

import com.example.restfulapi.entity.Customer;
import com.example.restfulapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        int id = repository.findAll().size() + 1;
        customer.setId(id);
        return repository.save(customer);
    }
}
