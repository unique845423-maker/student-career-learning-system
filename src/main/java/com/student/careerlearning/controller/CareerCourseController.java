package com.student.careerlearning.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.model.CareerCourse;
import com.student.careerlearning.repository.CareerCourseRepository;

@RestController
@RequestMapping("/api/career-courses")
public class CareerCourseController {


private final CareerCourseRepository careerCourseRepository;

public CareerCourseController(
        CareerCourseRepository careerCourseRepository) {

    this.careerCourseRepository = careerCourseRepository;
}

@GetMapping
public ResponseEntity<?> getAllCourses() {

    List<CareerCourse> courses =
            careerCourseRepository.findAll();

    return ResponseEntity.ok(courses);
}

@GetMapping("/by-stream")
public ResponseEntity<?> getCoursesByStream(
        @RequestParam String stream) {

    if (stream == null || stream.isBlank()) {
        return ResponseEntity
                .badRequest()
                .body("Stream is required");
    }

    stream = stream.trim();

    if (stream.length() > 50) {
        return ResponseEntity
                .badRequest()
                .body("Stream value is too long");
    }

    List<CareerCourse> courses =
            careerCourseRepository.findByStream(stream);

    return ResponseEntity.ok(courses);
}

@GetMapping("/by-subjects")
public ResponseEntity<?> getCoursesByStreamAndSubjects(
        @RequestParam String stream,
        @RequestParam String subjectCombination) {

    if (stream == null || stream.isBlank()) {
        return ResponseEntity
                .badRequest()
                .body("Stream is required");
    }

    if (subjectCombination == null ||
            subjectCombination.isBlank()) {

        return ResponseEntity
                .badRequest()
                .body("Subject combination is required");
    }

    stream = stream.trim();
    subjectCombination = subjectCombination.trim();

    if (stream.length() > 50) {
        return ResponseEntity
                .badRequest()
                .body("Stream value is too long");
    }

    if (subjectCombination.length() > 50) {
        return ResponseEntity
                .badRequest()
                .body("Subject combination is too long");
    }

    List<CareerCourse> courses =
            careerCourseRepository
                    .findByStreamAndSubjectCombination(
                            stream,
                            subjectCombination
                    );

    return ResponseEntity.ok(courses);
}


}
