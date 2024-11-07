package com.example.laba2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students;

    public List<Student> getStudents(){
        return students;
    }

    @PostConstruct
    public void init(){
        students = new ArrayList<>();
        students.add(new Student(1, "Karpov", "Denis", "Valer", "Murom",
                "man", 23, "FITR", "PIn-121"));
        students.add(new Student(1, "Karpov", "Denis", "Valer", "Murom",
                "man", 23, "FITR", "PIn-121"));
        students.add(new Student(1, "Karpov", "Denis", "Valer", "Murom",
                "man", 23, "FITR", "PIn-121"));

    }

    public void deleteById(Long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return;
            }
        }
    }

    public List<Student> findAll() {
        return  students;
    }

    public void save(Student student) {
        students.add(student);


    }
}
