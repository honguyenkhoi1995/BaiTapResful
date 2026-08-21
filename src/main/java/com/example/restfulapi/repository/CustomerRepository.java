package com.example.restfulapi.repository;

import com.example.restfulapi.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.add(new Customer(1, "Nguyen Van A", "0900000001"));
        customers.add(new Customer(2, "Tran Thi B", "0900000002"));
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }
}
