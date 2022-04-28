package com.student.controller;

import com.student.models.Student;
import com.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About page");
        return "about";
    }

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/blog")
    public String blog (Model model){
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "blog";
    }
//    @GetMapping("/blog")
//    public String blog(Model model) {
//        model.addAttribute("title", "News page");
//        return "blog";
//    }
    
}
