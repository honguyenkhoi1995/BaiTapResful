package com.example.restfulapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calc/add")
    public double add(@RequestParam double x, @RequestParam double y) {
        return x + y;
    }

    @GetMapping("/calc/subtract")
    public double subtract(@RequestParam double x, @RequestParam double y) {
        return x - y;
    }

    @GetMapping("/calc/multiply")
    public double multiply(@RequestParam double x, @RequestParam double y) {
        return x * y;
    }

    @GetMapping("/calc/divide")
    public double divide(@RequestParam double x, @RequestParam double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }
}
