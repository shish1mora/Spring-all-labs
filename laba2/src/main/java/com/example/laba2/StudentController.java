package com.example.laba2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/institut")
    public String mainPage(Model model){
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("students", allStudents);
        return "institut";
    }
    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Student selectedStudent = studentService.getStudentById(id);
        model.addAttribute("selectedStudent", selectedStudent);
        return "details";
    }
    @GetMapping("/students/delete/{id}")
    public String deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return "redirect:/institut";
    }
    @GetMapping("/addstudent")
    public String addStudentform(Model model){
        model.addAttribute("student", new Student());
        return "addstudent";
    }
    @PostMapping("/addstudent")
    public String addStudentform(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        studentService.addStudent(student);
        return "redirect:/institut";
    }
}