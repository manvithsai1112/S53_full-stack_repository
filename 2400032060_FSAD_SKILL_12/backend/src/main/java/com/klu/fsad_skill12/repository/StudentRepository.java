package com.klu.fsad_skill12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.fsad_skill12.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}