package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        product.setId(nextId++);
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable int id,
            @RequestBody Product request) {

        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(request.getName());
                product.setPrice(request.getPrice());
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
