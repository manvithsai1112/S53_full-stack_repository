package com.klu.fsad_skill12.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.fsad_skill12.entity.Student;
import com.klu.fsad_skill12.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Student update(Long id, Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }
}