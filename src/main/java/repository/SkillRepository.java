package com.student.careerlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.careerlearning.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByUsername(String username);

    void deleteByIdAndUsername(Long id, String username);
}
