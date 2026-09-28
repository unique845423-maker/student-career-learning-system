package com.student.careerlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.careerlearning.model.CareerCourse;

public interface CareerCourseRepository
        extends JpaRepository<CareerCourse, Long> {

    List<CareerCourse> findByStream(String stream);

    List<CareerCourse> findByStreamAndSubjectCombination(
            String stream,
            String subjectCombination
    );
}