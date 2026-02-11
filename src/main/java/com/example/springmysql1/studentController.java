package com.example.springmysql1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

    private final studentRepository repository;

    public studentController(studentRepository repository) {
        this.repository = repository;
    }

    // insert student
    @PostMapping
    public student addStudent(@RequestBody student student) {
        return repository.save(student);
    }

    // get all students
    @GetMapping
    public List<student> getAllStudents() {
        return repository.findAll();
    }
}
