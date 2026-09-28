package com.student.careerlearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.careerlearning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsername(String username);

    Optional<Student> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}