package com.course.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.course.model.Course;
import com.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Course c) {
        service.addCourse(c);
        return new ResponseEntity<>("Course added", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Course c = service.getCourse(id);
        if (c == null)
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Course c) {
        Course updated = service.updateCourse(id, c);
        if (updated == null)
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);
        if (!deleted)
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}