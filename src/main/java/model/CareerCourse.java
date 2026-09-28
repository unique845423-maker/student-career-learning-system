package com.student.careerlearning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CareerCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic Information
    private String stream;
    private String subjectCombination;
    private String course;
    private String duration;

    // Eligibility
    private String eligibility;
    private String requiredSubjects;

    // Course Information
    private String description;
    private String mainSubjects;
    private String skillsRequired;

    // Career Information
    private String careerOptions;
    private String jobRoles;

    // Higher Studies
    private String higherStudies;

    // Admission Information
    private String entranceExams;
    private String admissionProcess;

    // Salary Information
    private String salaryInfo;

    public CareerCourse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSubjectCombination() {
        return subjectCombination;
    }

    public void setSubjectCombination(String subjectCombination) {
        this.subjectCombination = subjectCombination;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(String requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainSubjects() {
        return mainSubjects;
    }

    public void setMainSubjects(String mainSubjects) {
        this.mainSubjects = mainSubjects;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getCareerOptions() {
        return careerOptions;
    }

    public void setCareerOptions(String careerOptions) {
        this.careerOptions = careerOptions;
    }

    public String getJobRoles() {
        return jobRoles;
    }

    public void setJobRoles(String jobRoles) {
        this.jobRoles = jobRoles;
    }

    public String getHigherStudies() {
        return higherStudies;
    }

    public void setHigherStudies(String higherStudies) {
        this.higherStudies = higherStudies;
    }

    public String getEntranceExams() {
        return entranceExams;
    }

    public void setEntranceExams(String entranceExams) {
        this.entranceExams = entranceExams;
    }

    public String getAdmissionProcess() {
        return admissionProcess;
    }

    public void setAdmissionProcess(String admissionProcess) {
        this.admissionProcess = admissionProcess;
    }

    public String getSalaryInfo() {
        return salaryInfo;
    }

    public void setSalaryInfo(String salaryInfo) {
        this.salaryInfo = salaryInfo;
    }
}