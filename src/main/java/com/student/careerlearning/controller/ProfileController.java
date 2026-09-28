
package com.student.careerlearning.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.dto.ChangePasswordRequest;
import com.student.careerlearning.model.Student;
import com.student.careerlearning.repository.StudentRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfileController(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder) {

        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ==========================================
    // SECURITY CHECK
    // ==========================================

    private boolean isAuthorized(
            String username,
            HttpSession session) {

        Object loggedInUsername =
                session.getAttribute("loggedInUsername");

        if (loggedInUsername == null) {
            return false;
        }

        return username.equals(
                loggedInUsername.toString()
        );
    }

    // ==========================================
    // PROFILE RESPONSE
    // ==========================================

    private Map<String, Object> createProfileResponse(
            Student student) {

        Map<String, Object> profile =
                new LinkedHashMap<>();

        profile.put("id", student.getId());
        profile.put("name", student.getName());
        profile.put("email", student.getEmail());
        profile.put("phone", student.getPhone());
        profile.put("username", student.getUsername());

        // Password is intentionally NOT included.
        return profile;
    }

    // ==========================================
    // GET PROFILE
    // ==========================================

    @GetMapping("/{username}")
    public ResponseEntity<?> getProfile(
            @PathVariable String username,
            HttpSession session) {

        // User must be logged in
        if (!isAuthorized(username, session)) {

            return ResponseEntity
                    .status(401)
                    .body("Unauthorized");
        }

        Student student = studentRepository
                .findByUsername(username)
                .orElse(null);

        if (student == null) {

            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        return ResponseEntity.ok(
                createProfileResponse(student)
        );
    }

    // ==========================================
    // UPDATE PROFILE
    // ==========================================

    @PutMapping("/{username}")
    public ResponseEntity<?> updateProfile(
            @PathVariable String username,
            @RequestBody Map<String, String> data,
            HttpSession session) {

        // User can update only their own profile
        if (!isAuthorized(username, session)) {

            return ResponseEntity
                    .status(401)
                    .body("Unauthorized");
        }

        Student student = studentRepository
                .findByUsername(username)
                .orElse(null);

        if (student == null) {

            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        // ==========================================
        // NAME VALIDATION
        // ==========================================

        String name = data.get("name");

        if (name != null) {

            name = name.trim();

            if (name.isEmpty()) {

                return ResponseEntity
                        .badRequest()
                        .body("Name cannot be empty");
            }

            if (name.length() > 100) {

                return ResponseEntity
                        .badRequest()
                        .body("Name is too long");
            }

            student.setName(name);
        }

        // ==========================================
        // PHONE VALIDATION
        // ==========================================

        String phone = data.get("phone");

        if (phone != null) {

            phone = phone.trim();

            if (!phone.isEmpty() &&
                    !phone.matches("\\d{10}")) {

                return ResponseEntity
                        .badRequest()
                        .body("Phone number must contain exactly 10 digits");
            }

            if (!phone.isEmpty()) {
                student.setPhone(phone);
            }
        }

        Student updatedStudent =
                studentRepository.save(student);

        return ResponseEntity.ok(
                createProfileResponse(updatedStudent)
        );
    }

    // ==========================================
    // CHANGE PASSWORD
    // ==========================================

    @PostMapping("/{username}/change-password")
    public ResponseEntity<?> changePassword(
            @PathVariable String username,
            @RequestBody ChangePasswordRequest request,
            HttpSession session) {

        // User can change only their own password
        if (!isAuthorized(username, session)) {

            return ResponseEntity
                    .status(401)
                    .body("Unauthorized");
        }

        Student student = studentRepository
                .findByUsername(username)
                .orElse(null);

        if (student == null) {

            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        // ==========================================
        // CURRENT PASSWORD
        // ==========================================

        if (request.getCurrentPassword() == null ||
                request.getCurrentPassword().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("Current password is required");
        }

        // ==========================================
        // NEW PASSWORD
        // ==========================================

        if (request.getNewPassword() == null ||
                request.getNewPassword().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("New password is required");
        }

        // Minimum password length
        if (request.getNewPassword().length() < 8) {

            return ResponseEntity
                    .badRequest()
                    .body("New password must be at least 8 characters");
        }

        // ==========================================
        // CONFIRM PASSWORD
        // ==========================================

        if (request.getConfirmPassword() == null ||
                request.getConfirmPassword().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("Confirm password is required");
        }

        // ==========================================
        // VERIFY CURRENT PASSWORD
        // ==========================================

        if (!passwordEncoder.matches(
                request.getCurrentPassword(),
                student.getPassword())) {

            return ResponseEntity
                    .status(401)
                    .body("Current password is incorrect");
        }

        // ==========================================
        // VERIFY NEW PASSWORD
        // ==========================================

        if (!request.getNewPassword()
                .equals(request.getConfirmPassword())) {

            return ResponseEntity
                    .badRequest()
                    .body("New passwords do not match");
        }

        // Prevent using the same password
        if (passwordEncoder.matches(
                request.getNewPassword(),
                student.getPassword())) {

            return ResponseEntity
                    .badRequest()
                    .body("New password must be different from current password");
        }

        // ==========================================
        // ENCRYPT NEW PASSWORD
        // ==========================================

        String encryptedPassword =
                passwordEncoder.encode(
                        request.getNewPassword()
                );

        student.setPassword(encryptedPassword);

        studentRepository.save(student);

        return ResponseEntity.ok(
                "Password changed successfully"
        );
    }
}

