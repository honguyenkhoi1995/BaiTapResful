package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Employee;
import com.example.restfulapi.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        employees.add(new Employee(1, "Nguyen Van A", "Developer"));
        employees.add(new Employee(2, "Tran Thi B", "Tester"));
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
