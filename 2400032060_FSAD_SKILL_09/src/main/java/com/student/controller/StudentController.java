package com.student.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.student.exception.*;
import com.student.model.Student;

@RestController
public class StudentController {

    List<Student> list = Arrays.asList(
            new Student(1, "Manvith", "CSE"),
            new Student(2, "Sai", "IT")
    );

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Invalid ID format. ID must be positive.");
        }

        return list.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
}