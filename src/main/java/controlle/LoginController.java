package com.student.careerlearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.dto.LoginRequest;
import com.student.careerlearning.model.Student;
import com.student.careerlearning.repository.StudentRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder) {

        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request,
            HttpSession session) {

        String username = request.getUsername();
        String password = request.getPassword();

        if (username == null || password == null ||
                username.isBlank() || password.isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Username and password are required");
        }

        Student student = studentRepository
                .findByUsername(username)
                .orElse(null);

        if (student == null) {
            return ResponseEntity.status(401)
                    .body("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, student.getPassword())) {
            return ResponseEntity.status(401)
                    .body("Invalid username or password");
        }

        // Store the authenticated student's username in server session
        session.setAttribute("loggedInUsername", student.getUsername());

        return ResponseEntity.ok("Login successful");
    }
}