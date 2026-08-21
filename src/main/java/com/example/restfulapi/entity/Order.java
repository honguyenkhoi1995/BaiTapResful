package com.example.restfulapi.entity;

import java.util.List;

public class Order {

    private int id;
    private String customerName;
    private List<Product> products;

    public Order() {
    }

    public Order(int id, String customerName, List<Product> products) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
