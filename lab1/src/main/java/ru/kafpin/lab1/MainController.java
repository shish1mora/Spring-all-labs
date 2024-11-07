package ru.kafpin.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/home")
    public String home(Model model){

        return "home";
    }

    @GetMapping("/form")
    public String mainForm(Model model){
        model.addAttribute("student", new Student());
        return "main-form";
    }
    @PostMapping("/form")
    public String mainForm(@ModelAttribute Student student, Model
            model){
        model.addAttribute("student", student);
        return "result";
    }
}
