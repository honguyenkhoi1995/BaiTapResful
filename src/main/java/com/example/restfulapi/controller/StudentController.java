package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student.setId(nextId++);
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
