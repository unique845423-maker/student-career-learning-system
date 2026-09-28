package com.student.careerlearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.model.Student;
import com.student.careerlearning.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {

        try {
            Student registeredStudent = studentService.registerStudent(student);

            registeredStudent.setPassword(null);

            return ResponseEntity.ok(registeredStudent);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}