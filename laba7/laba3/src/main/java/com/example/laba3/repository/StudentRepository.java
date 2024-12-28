package com.example.laba3.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.laba3.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}