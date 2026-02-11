package com.example.springmysql1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class studentPageController {

    private final studentRepository repository;

    public studentPageController(studentRepository repository) {
        this.repository = repository;
    }

    // Show form
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new student());
        return "add-student";
    }

    // Save student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute student student) {
        repository.save(student);
        return "redirect:/students/list";
    }

    // Show all students
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<student> students = repository.findAll();
        model.addAttribute("students", students);
        return "list-students";
    }
    
    // delete student by id
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/students/list";
    }

    // update student by id
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        student student = repository.findById(id).orElseThrow();
        model.addAttribute("student", student);
        return "edit-student";
    }
}
