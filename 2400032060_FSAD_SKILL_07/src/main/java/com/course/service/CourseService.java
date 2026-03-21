package com.course.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Course;
import com.course.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course c) {
        return repo.save(c);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourse(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course updateCourse(int id, Course c) {
        if (!repo.existsById(id)) return null;
        return repo.save(c);
    }

    public boolean deleteCourse(int id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}