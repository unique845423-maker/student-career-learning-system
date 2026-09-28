package com.student.careerlearning.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.student.careerlearning.model.Student;
import com.student.careerlearning.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository,
                          PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Student registerStudent(Student student) {

        if (studentRepository.existsByUsername(student.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (studentRepository.existsByPhone(student.getPhone())) {
            throw new RuntimeException("Phone number already exists");
        }

        // Password को सुरक्षित hash में बदलना
        student.setPassword(
                passwordEncoder.encode(student.getPassword())
        );

        return studentRepository.save(student);
    }
}