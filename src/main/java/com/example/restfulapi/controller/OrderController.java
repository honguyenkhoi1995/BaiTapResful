package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        order.setId(nextId++);

        if (order.getProducts() == null) {
            order.setProducts(new ArrayList<>());
        }

        orders.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orders;
    }
}
