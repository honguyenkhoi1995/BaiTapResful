package com.example.restfulapi.controller;

import com.example.restfulapi.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private final GreetingService greetingService;

    public BasicController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return greetingService.sayHello(name);
    }
}
