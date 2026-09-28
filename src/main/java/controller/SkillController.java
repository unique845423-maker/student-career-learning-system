package com.student.careerlearning.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.model.Skill;
import com.student.careerlearning.repository.SkillRepository;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController {

    private final SkillRepository skillRepository;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    // =========================================================
    // GET ALL SKILLS OF A USER
    // =========================================================

    @GetMapping("/{username}")
    public ResponseEntity<List<Skill>> getSkills(
            @PathVariable String username) {

        if (username == null || username.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        List<Skill> skills =
                skillRepository.findByUsername(username.trim());

        return ResponseEntity.ok(skills);
    }

    // =========================================================
    // ADD NEW SKILL
    // =========================================================

    @PostMapping
    public ResponseEntity<?> addSkill(
            @RequestBody Skill skill) {

        if (skill == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Skill data is required");
        }

        // -----------------------------------------------------
        // Validate Username
        // -----------------------------------------------------

        if (skill.getUsername() == null
                || skill.getUsername().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("Username is required");
        }

        // -----------------------------------------------------
        // Validate Skill Name
        // -----------------------------------------------------

        if (skill.getSkillName() == null
                || skill.getSkillName().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("Skill name is required");
        }

        // -----------------------------------------------------
        // Clean Text Data
        // -----------------------------------------------------

        skill.setUsername(
                skill.getUsername().trim()
        );

        skill.setSkillName(
                skill.getSkillName().trim()
        );

        if (skill.getAcademicLevel() != null) {
            skill.setAcademicLevel(
                    skill.getAcademicLevel().trim()
            );
        }

        if (skill.getCategory() != null) {
            skill.setCategory(
                    skill.getCategory().trim()
            );
        }

        if (skill.getSkillLevel() != null) {
            skill.setSkillLevel(
                    skill.getSkillLevel().trim()
            );
        }

        // -----------------------------------------------------
        // Keep Progress Between 0 and 100
        // -----------------------------------------------------

        int progress = skill.getProgress();

        progress = Math.max(
                0,
                Math.min(100, progress)
        );

        skill.setProgress(progress);

        // -----------------------------------------------------
        // Save Skill
        // -----------------------------------------------------

        Skill savedSkill =
                skillRepository.save(skill);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedSkill);
    }

    // =========================================================
    // UPDATE / EDIT SKILL
    // =========================================================

    @PutMapping("/{id}/{username}")
    public ResponseEntity<?> updateSkill(
            @PathVariable Long id,
            @PathVariable String username,
            @RequestBody Skill updatedSkill) {

        // -----------------------------------------------------
        // Validate ID
        // -----------------------------------------------------

        if (id == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Skill ID is required");
        }

        // -----------------------------------------------------
        // Validate Username
        // -----------------------------------------------------

        if (username == null || username.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Username is required");
        }

        username = username.trim();

        // -----------------------------------------------------
        // Find Existing Skill
        // -----------------------------------------------------

        Skill existingSkill =
                skillRepository
                        .findById(id)
                        .orElse(null);

        // -----------------------------------------------------
        // Skill Not Found
        // -----------------------------------------------------

        if (existingSkill == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Skill not found");
        }

        // =====================================================
        // SECURITY CHECK
        // =====================================================

        if (existingSkill.getUsername() == null
                || !username.equals(
                        existingSkill.getUsername())) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(
                            "You are not allowed to edit this skill"
                    );
        }

        // =====================================================
        // VALIDATE REQUEST BODY
        // =====================================================

        if (updatedSkill == null) {

            return ResponseEntity
                    .badRequest()
                    .body("Updated skill data is required");
        }

        // =====================================================
        // UPDATE SKILL NAME
        // =====================================================

        if (updatedSkill.getSkillName() != null
                && !updatedSkill.getSkillName().isBlank()) {

            existingSkill.setSkillName(
                    updatedSkill
                            .getSkillName()
                            .trim()
            );
        }

        // =====================================================
        // UPDATE ACADEMIC LEVEL
        // =====================================================

        if (updatedSkill.getAcademicLevel() != null
                && !updatedSkill
                        .getAcademicLevel()
                        .isBlank()) {

            existingSkill.setAcademicLevel(
                    updatedSkill
                            .getAcademicLevel()
                            .trim()
            );
        }

        // =====================================================
        // UPDATE CATEGORY
        // =====================================================

        if (updatedSkill.getCategory() != null
                && !updatedSkill
                        .getCategory()
                        .isBlank()) {

            existingSkill.setCategory(
                    updatedSkill
                            .getCategory()
                            .trim()
            );
        }

        // =====================================================
        // UPDATE SKILL LEVEL
        // =====================================================

        if (updatedSkill.getSkillLevel() != null
                && !updatedSkill
                        .getSkillLevel()
                        .isBlank()) {

            existingSkill.setSkillLevel(
                    updatedSkill
                            .getSkillLevel()
                            .trim()
            );
        }

        // =====================================================
        // UPDATE PROGRESS
        // =====================================================
        // IMPORTANT:
        // getProgress() is int, so we cannot compare it with null.
        // =====================================================

        int progress =
                updatedSkill.getProgress();

        progress = Math.max(
                0,
                Math.min(100, progress)
        );

        existingSkill.setProgress(progress);

        // =====================================================
        // SAVE UPDATED SKILL
        // =====================================================

        Skill savedSkill =
                skillRepository.save(
                        existingSkill
                );

        return ResponseEntity.ok(
                savedSkill
        );
    }

    // =========================================================
    // DELETE SKILL
    // =========================================================

    @DeleteMapping("/{id}/{username}")
    public ResponseEntity<?> deleteSkill(
            @PathVariable Long id,
            @PathVariable String username) {

        // -----------------------------------------------------
        // Validate Username
        // -----------------------------------------------------

        if (username == null || username.isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("Username is required");
        }

        username = username.trim();

        // -----------------------------------------------------
        // Find Skill
        // -----------------------------------------------------

        Skill existingSkill =
                skillRepository
                        .findById(id)
                        .orElse(null);

        // -----------------------------------------------------
        // Skill Not Found
        // -----------------------------------------------------

        if (existingSkill == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Skill not found");
        }

        // =====================================================
        // SECURITY CHECK
        // =====================================================

        if (existingSkill.getUsername() == null
                || !username.equals(
                        existingSkill.getUsername())) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(
                            "You are not allowed to delete this skill"
                    );
        }

        // =====================================================
        // DELETE
        // =====================================================

        skillRepository.delete(existingSkill);

        return ResponseEntity.ok(
                "Skill deleted successfully"
        );
    }
}