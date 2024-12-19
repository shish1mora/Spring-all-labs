package com.example.laba3.controller;

import com.example.laba3.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.laba3.model.Student;
import com.example.laba3.repository.StudentRepository;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final EmailService emailService;

    @Autowired
    public StudentController(StudentRepository studentRepository, EmailService emailService) {
        this.studentRepository = studentRepository;
        this.emailService = emailService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student_list";
    }

    @GetMapping("/create")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "edit_student";
        } else {
            return "redirect:/students/list";
        }
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        return "redirect:/students/list";

    }
    @GetMapping("/write/{id}")
    public String writeEmail(Model model, @PathVariable("id") Long id){
        Student student = studentRepository.findById(id).get();
        String message = "Карпов Денис, ПИН-121, Практика1";
        String email = student.getEmail();
        emailService.sendSimpleEmail(email, "Практика 1", message);
        return "redirect:/students/list";
}

}